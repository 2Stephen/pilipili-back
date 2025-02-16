package com.pilipili.pilipiliback.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pilipili.pilipiliback.controller.vo.HotSearchVo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hotSearchBuss")
public class HotSearchController {
    @GetMapping("/hotSearch")
    @ResponseBody
    public ResponseEntity<List> hotSearch() {
        List list = new ArrayList();
        /*
                    {
                        id: 1,
                        title: '哈利波特落户上海',
                        tag: '新',
                        tagType: 'new'
                    },
                    {
                        id: 2,
                        title: '哪吒2票房破92亿',
                        tag: '热',
                        tagType: 'hot'
                    },
                    {id:3,
                        title: '原神新版本实况',
                        tag: '直播中',
                        tagType: 'live'
                    },
                    {id:4,
                        title: '开学了痛苦面具已戴上'
                    },
                    {id:5,
                        title: '中国登月服命名为望宇'
                    },
                    {id:6,
                        title: '第五人格福尔摩斯联动',
                        tag: '新',
                        tagType: 'new'
                    },
                    {id:7,
                        title: '饺子说想起哪吒3就头疼'
                    },
                    {id:8,
                        title: '汪峰不是年轻人首选但不会被忽视',
                        tag: '独家',
                        tagType: 'exclusive'
                    },
                    {id:9,
                        title: '今日天庭无人值班',
                        tag: '梗',
                        tagType: 'meme'
                    },
                    {id:10,
                        title: '曝阿里将为中国iPhone开发AI功能'
                    }
         */
        list.add(new HotSearchVo(1, "哈利波特落户上海", "新", "new"));
        list.add(new HotSearchVo(2, "哪吒2票房破92亿", "热", "hot"));
        list.add(new HotSearchVo(3, "原神新版本实况", "直播中", "live"));
        list.add(new HotSearchVo(4, "开学了痛苦面具已戴上", null, null));
        list.add(new HotSearchVo(5, "中国登月服命名为望宇", null, null));
        list.add(new HotSearchVo(6, "第五人格福尔摩斯联动", "新", "new"));
        list.add(new HotSearchVo(7, "饺子说想起哪吒3就头疼", null, null));
        list.add(new HotSearchVo(8, "汪峰不是年轻人首选但不会被忽视", "独家", "exclusive"));
        list.add(new HotSearchVo(9, "今日天庭无人值班", "梗", "meme"));
        list.add(new HotSearchVo(10, "曝阿里将为中国iPhone开发AI功能", null, null));
        return ResponseEntity.ok(list);
    }
}
