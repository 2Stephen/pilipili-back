package com.pilipili.pilipiliback;

import com.pilipili.pilipiliback.entity.Barrages;
import com.pilipili.pilipiliback.repository.BarragesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MongoTest {
    @Autowired
    private BarragesRepository barragesRepository;

    //测试弹幕函数
    @Test
    public void testBarrages(){
        List<Barrages> barrages = barragesRepository.findByVideoidAndTimeBetween(3, 0, Integer.MAX_VALUE);
        System.out.println(barrages);
    }
}
