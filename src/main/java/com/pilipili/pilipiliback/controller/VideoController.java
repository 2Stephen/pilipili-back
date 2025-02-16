package com.pilipili.pilipiliback.controller;


import com.pilipili.pilipiliback.entity.Video;
import com.pilipili.pilipiliback.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videoBuss")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/getVideo")
    public ResponseEntity<Video> getVideo(@RequestParam Integer videoid) {
        Video video = videoService.getVideoById(videoid);
        if (video == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(video);

    }

}
