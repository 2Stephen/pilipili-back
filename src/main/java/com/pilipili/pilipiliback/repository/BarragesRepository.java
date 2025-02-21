package com.pilipili.pilipiliback.repository;


import com.pilipili.pilipiliback.entity.Barrages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarragesRepository extends MongoRepository<Barrages, String> {
    List<Barrages> findByVideoidAndTimeBetween(Integer videoid, Integer timeBefore, Integer timeAfter);

}
