package com.pilipili.pilipiliback.repository;

import com.pilipili.pilipiliback.entity.VideoStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoStatusRepository extends MongoRepository<VideoStatus, String> {
}
