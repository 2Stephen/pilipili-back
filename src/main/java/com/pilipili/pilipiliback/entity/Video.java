package com.pilipili.pilipiliback.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Transient;

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

    @JsonIgnore
    @TableField("userid")
    private Integer userid;

    @TableField("releasetime")
    private Integer releasetime;

    @JsonIgnore
    @Transient
    @TableField("views")
    private Integer views;

    @Transient
    @JsonIgnore
    @TableField("barrages")
    private Integer barrages;

    @Transient
    @TableField("likes")
    private Integer likes;

    @JsonIgnore
    @TableField("time")
    private Integer time;

    @Transient
    @TableField("collections")
    private Integer collections;

    @Transient
    @TableField("comments")
    private Integer comments;

    @Transient
    @TableField("forwards")
    private Integer forwards;
}
