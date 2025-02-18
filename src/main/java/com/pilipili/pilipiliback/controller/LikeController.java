package com.pilipili.pilipiliback.controller;


import com.pilipili.pilipiliback.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likeBuss")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping("/isLiked")
    public ResponseEntity<Boolean> isLiked(@RequestParam Integer userid, @RequestParam Integer videoid) {
        Boolean isLiked = likeService.isMember(userid, videoid);
        return ResponseEntity.ok(isLiked);
    }
    @GetMapping("/like")
    public ResponseEntity<String> like(@RequestParam Integer timestamp, @RequestParam Integer userid, @RequestParam Integer videoid, @RequestParam Integer like) {
        Integer likeAns = likeService.like(timestamp, userid, videoid);
        if (likeAns == 1 && like == 0) {
            return ResponseEntity.ok("点赞成功");
        } else if (likeAns == 0 && like == 1) {
            return ResponseEntity.ok("取消点赞成功");
        } else if (likeAns == 1 && like == 1) {
            return ResponseEntity.badRequest().body("取消点赞失败");
        } else {
            return ResponseEntity.badRequest().body("点赞失败");
        }
    }

}
