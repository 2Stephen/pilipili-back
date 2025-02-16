package com.pilipili.pilipiliback.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.pilipiliback.entity.Video;
import com.pilipili.pilipiliback.mapper.VideoMapper;
import com.pilipili.pilipiliback.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video getVideoById(Integer videoid) {
        return videoMapper.getVideoById(videoid);
    }
}
