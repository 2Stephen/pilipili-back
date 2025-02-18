package com.pilipili.pilipiliback.service.Impl;

import com.pilipili.pilipiliback.entity.VideoStatus;
import com.pilipili.pilipiliback.repository.VideoStatusRepository;
import com.pilipili.pilipiliback.service.VideoStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class VideoStatusServiceImpl implements VideoStatusService{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private VideoStatusRepository videoStatusRepository;
    @Override
    public VideoStatus getVideoStatus(Integer videoid) {
        // 从缓存中获取点赞数
        Integer likeCount = (Integer) redisTemplate.opsForValue().get("likedCount:" + videoid);
        // 从缓存中获取收藏数
        Integer collectCount = (Integer) redisTemplate.opsForValue().get("collectedCount:" + videoid);
        // 从缓存中获取观看数
        Integer viewCount = (Integer) redisTemplate.opsForValue().get("viewedCount:" + videoid);
        // 从缓存中获取评论数
        Integer commentCount = (Integer) redisTemplate.opsForValue().get("commentedCount:" + videoid);
        // 从缓存中获取转发数
        Integer forwardCount = (Integer) redisTemplate.opsForValue().get("forwardedCount:" + videoid);
        // 从缓存中获取弹幕数
        Integer barrageCount = (Integer) redisTemplate.opsForValue().get("barragedCount:" + videoid);
        // 如果上述任意一个数值为空，从数据库中获取
        if (likeCount == null || collectCount == null || viewCount == null || commentCount == null || forwardCount == null || barrageCount == null) {
            Optional<VideoStatus> VideoStatus = videoStatusRepository.findById(videoid.toString());
            // 更新缓存
            if (VideoStatus.isPresent()) {
                if (likeCount == null) {
                    redisTemplate.opsForValue().set("likedCount:" + videoid, VideoStatus.get().getLikeCount(),60, TimeUnit.MINUTES);
                }
                if (collectCount == null) {
                    redisTemplate.opsForValue().set("collectedCount:" + videoid, VideoStatus.get().getCollectCount(),60, TimeUnit.MINUTES);
                }
                if (viewCount == null) {
                    redisTemplate.opsForValue().set("viewedCount:" + videoid, VideoStatus.get().getViewCount(),60, TimeUnit.MINUTES);
                }
                if (commentCount == null) {
                    redisTemplate.opsForValue().set("commentedCount:" + videoid, VideoStatus.get().getCommentCount(),60, TimeUnit.MINUTES);
                }
                if (forwardCount == null) {
                    redisTemplate.opsForValue().set("forwardedCount:" + videoid, VideoStatus.get().getForwardCount(),60, TimeUnit.MINUTES);
                }
                if (barrageCount == null) {
                    redisTemplate.opsForValue().set("barragedCount:" + videoid, VideoStatus.get().getBarrageCount(),60, TimeUnit.MINUTES);
                }
                return VideoStatus.get();
            } else {
                return null;
            }
        }
        return new VideoStatus(likeCount, collectCount, viewCount, commentCount, forwardCount, barrageCount);
    }

    @Override
    public Integer setVideoStatus(Integer videoid, Integer status) {
        return null;
    }
}
