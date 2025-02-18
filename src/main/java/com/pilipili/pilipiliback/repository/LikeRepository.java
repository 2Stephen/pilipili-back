package com.pilipili.pilipiliback.repository;


import com.pilipili.pilipiliback.entity.Like;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends MongoRepository<Like, String>{


    // 根据视频id查找用户是否点赞
    Optional<Like> findByVideoIdAndUserId(String videoId, String userId);


}
