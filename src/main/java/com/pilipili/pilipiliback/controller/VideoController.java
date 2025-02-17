package com.pilipili.pilipiliback.controller;


import com.github.pagehelper.PageInfo;
import com.pilipili.pilipiliback.entity.Video;
import com.pilipili.pilipiliback.entity.VideoProfile;
import com.pilipili.pilipiliback.service.VideoProfileService;
import com.pilipili.pilipiliback.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videoBuss")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoProfileService videoProfileService;
    @GetMapping("/getVideoList")
    public ResponseEntity<PageInfo<VideoProfile>> getVideoList(@RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "8") Integer pagesize) {
        PageInfo<VideoProfile> videoList = videoProfileService.getVideoList(page, pagesize);
        return ResponseEntity.ok(videoList);
    }

    @GetMapping("/getVideo")
    public ResponseEntity<Video> getVideo(@RequestParam Integer videoid) {
        Video video = videoService.getVideo(videoid);
        if (video == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(video);

    }

}
