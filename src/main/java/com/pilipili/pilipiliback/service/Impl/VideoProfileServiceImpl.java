package com.pilipili.pilipiliback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pilipili.pilipiliback.entity.VideoProfile;
import com.pilipili.pilipiliback.mapper.VideoProfileMapper;
import com.pilipili.pilipiliback.service.VideoProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class VideoProfileServiceImpl extends ServiceImpl<VideoProfileMapper, VideoProfile> implements VideoProfileService {
    @Autowired
    private VideoProfileMapper videoProfileMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private VideoStatusServiceImpl videoStatusServiceImpl;
    @Override
    public PageInfo<VideoProfile> getVideoList(Integer page, Integer pagesize) {
        PageHelper.startPage(page, pagesize);
        List<VideoProfile> videoProfiles =  videoProfileMapper.getVideoList(page, pagesize);
        for (VideoProfile videoProfile : videoProfiles) {
            // 查询views和barrages数量
            Integer viewCount = (Integer) redisTemplate.opsForValue().get("viewedCount:" + videoProfile.getVideoid());
            Integer barrageCount = (Integer) redisTemplate.opsForValue().get("barragedCount:" + videoProfile.getVideoid());
            if (viewCount == null) {
                viewCount = videoStatusServiceImpl.getVideoStatus(videoProfile.getVideoid()).getViewCount();
                redisTemplate.opsForValue().set("viewedCount:" + videoProfile.getVideoid(), viewCount,60, TimeUnit.MINUTES);
            }
            if (barrageCount == null) {
                barrageCount = videoStatusServiceImpl.getVideoStatus(videoProfile.getVideoid()).getBarrageCount();
                redisTemplate.opsForValue().set("barragedCount:" + videoProfile.getVideoid(), barrageCount,60, TimeUnit.MINUTES);
            }
            videoProfile.setViews(viewCount);
            videoProfile.setBarrages(barrageCount);
        }
        return new PageInfo<>(videoProfiles);
    }
}
