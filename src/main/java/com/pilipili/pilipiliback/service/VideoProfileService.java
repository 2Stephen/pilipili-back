package com.pilipili.pilipiliback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.pilipili.pilipiliback.entity.VideoProfile;

import java.util.List;

public interface VideoProfileService extends IService<VideoProfile> {
    public PageInfo<VideoProfile> getVideoList(Integer page, Integer pagesize);
}
