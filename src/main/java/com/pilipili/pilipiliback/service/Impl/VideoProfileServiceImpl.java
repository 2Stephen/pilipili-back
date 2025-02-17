package com.pilipili.pilipiliback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pilipili.pilipiliback.entity.VideoProfile;
import com.pilipili.pilipiliback.mapper.VideoProfileMapper;
import com.pilipili.pilipiliback.service.VideoProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoProfileServiceImpl extends ServiceImpl<VideoProfileMapper, VideoProfile> implements VideoProfileService {
    @Autowired
    private VideoProfileMapper videoProfileMapper;
    @Override
    public PageInfo<VideoProfile> getVideoList(Integer page, Integer pagesize) {
        PageHelper.startPage(page, pagesize);
        List<VideoProfile> videoProfiles =  videoProfileMapper.getVideoList(page, pagesize);
        return new PageInfo<>(videoProfiles);
    }
}
