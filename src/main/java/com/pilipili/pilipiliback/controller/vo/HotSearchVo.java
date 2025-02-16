package com.pilipili.pilipiliback.controller.vo;


import jdk.jshell.Snippet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HotSearchVo {
    private Integer id;
    private String title;
    private String tag;
    private String tagType;

    public HotSearchVo() {}
    public HotSearchVo(Integer id, String title, String tag, String tagType) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.tagType = tagType;
    }
    @Override
    public String toString() {
        return "HotSearchVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", tagType=" + tagType +
                '}';
    }
}
