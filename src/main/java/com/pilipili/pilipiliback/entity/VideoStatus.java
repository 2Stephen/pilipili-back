package com.pilipili.pilipiliback.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VideoStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoStatus {
    @Id  // 标注为 MongoDB 的主键字段
    private String videoId;  // 存储视频的 ID
    private Integer likeCount;  // 点赞量
    private Integer collectCount;   // 收藏量
    private Integer viewCount;  // 观看量
    private Integer commentCount;  // 评论量
    private Integer forwardCount;  // 转发量
    private Integer barrageCount;  // 弹幕量

    public VideoStatus(Integer likeCount, Integer collectCount, Integer viewCount, Integer commentCount, Integer forwardCount, Integer barrageCount) {
        this.likeCount = likeCount;
        this.collectCount = collectCount;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.forwardCount = forwardCount;
        this.barrageCount = barrageCount;
    }
}
