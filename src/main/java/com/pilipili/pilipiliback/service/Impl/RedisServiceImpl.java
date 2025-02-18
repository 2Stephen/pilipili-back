package com.pilipili.pilipiliback.service.Impl;


import com.pilipili.pilipiliback.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @author: Stephen
     */
    @Override
    public Integer like(Integer timestamp, Integer userid, Integer videoid) {
        Boolean isMember = redisTemplate.opsForSet().isMember("likedUsers:" + videoid, userid);
        if (Boolean.TRUE.equals(isMember)) {
            redisTemplate.opsForSet().remove("likedUsers:" + videoid, userid);
            redisTemplate.opsForValue().decrement("likedCount:" + videoid, 1);

            return 0;
        } else {
            redisTemplate.opsForSet().add("likedUsers:" + videoid, userid);
            redisTemplate.opsForValue().increment("likedCount:" + videoid, 1);
            return 1;
        }
    }
}
