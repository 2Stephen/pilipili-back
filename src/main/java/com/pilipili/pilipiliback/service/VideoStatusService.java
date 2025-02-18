package com.pilipili.pilipiliback.service;


import com.pilipili.pilipiliback.entity.VideoStatus;

public interface VideoStatusService {
    // 获取视频状态
    VideoStatus getVideoStatus(Integer videoid);

    // 设置视频状态
    Integer setVideoStatus(Integer videoid, Integer status);
}
