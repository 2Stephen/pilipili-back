package com.pilipili.pilipiliback.service;

import com.pilipili.pilipiliback.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
public interface VideoService extends IService<Video> {
    Video getVideoById(Integer videoid);
}
