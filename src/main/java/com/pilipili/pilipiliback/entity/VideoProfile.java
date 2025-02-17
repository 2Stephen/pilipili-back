package com.pilipili.pilipiliback.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class VideoProfile {
    @TableId("videoid")
    private Integer videoid;

    @TableField("title")
    private String title;

    @TableField("cover")
    private String cover;

    @JsonIgnore
    @TableField("url")
    private String url;

    @JsonIgnore
    @TableField("zone")
    private String zone;

    @JsonIgnore
    @TableField("tags")
    private String tags;

    @JsonIgnore
    @TableField("abstracts")
    private String abstracts;

    @TableField("username")
    private String username;

    @JsonIgnore
    @TableField("releasetime")
    private Integer releasetime;

    @TableField("views")
    private Integer views;

    @TableField("barrages")
    private Integer barrages;

    @JsonIgnore
    @TableField("likes")
    private Integer likes;

    @TableField("time")
    private Integer time;

    @JsonIgnore
    @TableField("collections")
    private Integer collections;

    @JsonIgnore
    @TableField("comments")
    private Integer comments;

    @JsonIgnore
    @TableField("forwards")
    private Integer forwards;
}
