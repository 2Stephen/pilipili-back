package com.pilipili.pilipiliback.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Video {
    @JsonIgnore
    @TableId("videoid")
    private Integer videoid;

    @JsonIgnore
    @TableField("title")
    private String title;

    @JsonIgnore
    @TableField("cover")
    private String cover;

    @TableField("url")
    private String url;

    @JsonIgnore
    @TableField("zone")
    private String zone;

    @TableField("tags")
    private String tags;

    @TableField("abstracts")
    private String abstracts;

    @JsonIgnore
    @TableField("username")
    private String username;

    @TableField("releasetime")
    private Integer releasetime;

    @JsonIgnore
    @TableField("views")
    private Integer views;

    @JsonIgnore
    @TableField("barrages")
    private Integer barrages;

    @TableField("likes")
    private Integer likes;

    @JsonIgnore
    @TableField("time")
    private Integer time;
    @TableField("collections")
    private Integer collections;
    @TableField("comments")
    private Integer comments;
    @TableField("forwards")
    private Integer forwards;

}
