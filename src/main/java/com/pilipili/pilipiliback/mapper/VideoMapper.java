package com.pilipili.pilipiliback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pilipili.pilipiliback.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    Video getVideoById(@Param("videoid")Integer videoid);
}
