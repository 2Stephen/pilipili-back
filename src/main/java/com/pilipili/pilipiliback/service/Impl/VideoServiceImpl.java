package com.pilipili.pilipiliback.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pilipili.pilipiliback.entity.Video;
import com.pilipili.pilipiliback.entity.VideoStatus;
import com.pilipili.pilipiliback.mapper.VideoMapper;
import com.pilipili.pilipiliback.service.LikeService;
import com.pilipili.pilipiliback.service.VideoService;
import com.pilipili.pilipiliback.service.VideoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoStatusService videoStatusService;

    @Override
    public Video getVideo(Integer videoid) {
        // 获取视频信息
        VideoStatus videoStatus = videoStatusService.getVideoStatus(videoid);
        Video video = videoMapper.getVideoById(videoid);

        video.setLikes(videoStatus.getLikeCount());
        video.setCollections(videoStatus.getCollectCount());
        video.setViews(videoStatus.getViewCount());
        video.setComments(videoStatus.getCommentCount());
        video.setForwards(videoStatus.getForwardCount());

        return video;
    }
}
