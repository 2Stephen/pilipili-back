package com.pilipili.pilipiliback.service;

public interface RedisService {
    Integer like(Integer timestamp, Integer userid, Integer videoid);
}
