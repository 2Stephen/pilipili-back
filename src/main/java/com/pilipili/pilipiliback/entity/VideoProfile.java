package com.pilipili.pilipiliback.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Transient;

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

    @TableField("userid")
    private Integer userid;

    @JsonIgnore
    @TableField("releasetime")
    private Integer releasetime;

    @Transient
    @TableField("views")
    private Integer views;

    @Transient
    @TableField("barrages")
    private Integer barrages;

    @Transient
    @JsonIgnore
    @TableField("likes")
    private Integer likes;

    @TableField("time")
    private Integer time;

    @Transient
    @JsonIgnore
    @TableField("collections")
    private Integer collections;

    @Transient
    @JsonIgnore
    @TableField("comments")
    private Integer comments;

    @Transient
    @JsonIgnore
    @TableField("forwards")
    private Integer forwards;
}
