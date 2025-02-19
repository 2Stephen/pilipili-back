package com.pilipili.pilipiliback.repository;

import com.pilipili.pilipiliback.entity.VideoStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoStatusRepository extends MongoRepository<VideoStatus, String> {
    Optional<VideoStatus> findByVideoid(Integer videoid);
}
