package com.pilipili.pilipiliback.service;


public interface LikeService{
    Integer like(Integer timestamp, Integer userid, Integer videoid);

    Integer getLikeCount(Integer videoid);

    // 判断用户是否已经点赞
    Boolean isMember(Integer userid, Integer videoid);
}
