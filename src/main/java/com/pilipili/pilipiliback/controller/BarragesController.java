package com.pilipili.pilipiliback.controller;


import com.pilipili.pilipiliback.entity.Barrages;
import com.pilipili.pilipiliback.repository.BarragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barrageBuss")
public class BarragesController {
    @Autowired
    private BarragesRepository barragesRepository;

    @GetMapping("/getBarrageList")
    public ResponseEntity<List<Barrages>> getBarrageList(@RequestParam Integer videoid, @RequestParam(defaultValue = "0") Integer timeBefore, @RequestParam(defaultValue = "99999999") Integer timeAfter){
        List<Barrages> barrages = barragesRepository.findByVideoidAndTimeBetween(videoid, timeBefore, timeAfter);
        return ResponseEntity.ok(barrages);
    }
}
