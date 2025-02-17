package com.pilipili.pilipiliback.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pilipili.pilipiliback.entity.VideoProfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoProfileMapper extends BaseMapper<VideoProfile> {
    public List<VideoProfile> getVideoList(Integer page, Integer pagesize);
}
