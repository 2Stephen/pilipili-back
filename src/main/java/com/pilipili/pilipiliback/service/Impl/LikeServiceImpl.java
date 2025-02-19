package com.pilipili.pilipiliback.service.Impl;


import com.pilipili.pilipiliback.entity.Like;
import com.pilipili.pilipiliback.entity.VideoStatus;
import com.pilipili.pilipiliback.repository.LikeRepository;
import com.pilipili.pilipiliback.repository.VideoStatusRepository;
import com.pilipili.pilipiliback.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private VideoStatusRepository videoStatusRepository;
    @Override
    public Integer like(Integer timestamp, Integer userid, Integer videoid) {
        String countKey = "likedCount:" + videoid;
        String userKey = "likedUsers:" + videoid;
        String detailKey = "likedDetail:" + videoid;
        // 判断用户是否已经点赞
        Boolean isMember = isMember(userid, videoid);
        if (Boolean.TRUE.equals(isMember)) {
            redisTemplate.opsForSet().remove(userKey, userid);
            redisTemplate.opsForValue().decrement(countKey, 1);
            redisTemplate.opsForHash().delete(detailKey, userid);
            return 0;
        } else if (Boolean.FALSE.equals(isMember)){
            redisTemplate.opsForSet().add(userKey, userid);
            redisTemplate.opsForValue().increment(countKey, 1);
            redisTemplate.opsForHash().put(detailKey, userid, timestamp);
            return 1;
        }
        return -1;
    }

    @Override
    public Integer getLikeCount(Integer videoid) {
        // 从缓存中获取点赞数
        Integer likeCount = (Integer) redisTemplate.opsForValue().get("likedCount:" + videoid);
        // 如果缓存中没有该视频的点赞数，从数据库中获取
        if (likeCount == null) {
            // 从数据库中获取点赞数
            Optional<VideoStatus> VideoStatus = videoStatusRepository.findByVideoid(videoid);
            if (VideoStatus.isPresent()) {
                // 将点赞数存入缓存
                redisTemplate.opsForValue().set("likedCount:" + videoid, VideoStatus.get().getLikeCount(),60, TimeUnit.MINUTES);
                return VideoStatus.get().getLikeCount();
            } else {
                return 0;
            }
        }
        return likeCount;
    }

    @Override
    public Boolean isMember(Integer userid, Integer videoid) {
        Boolean isMember = redisTemplate.opsForSet().isMember("likedUsers:" + videoid, userid);
        // 如果缓存中没有该视频的点赞用户集合，从数据库中获取
        if (isMember == null) {
            // 从数据库中获取点赞信息
            Optional<Like>existingLike = likeRepository.findByVideoIdAndUserId(videoid.toString(), userid.toString());
            if (existingLike.isPresent()) {
                // 将点赞用户集合存入缓存
                //---------------------
                return true;
            } else {
                return false;
            }
        }
        return isMember;
    }
}
