package com.pilipili.pilipiliback.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    @Id  // 标注为 MongoDB 的主键字段
    private String id;
    private String videoId;  // 存储视频的 ID
    private String userId;   // 存储用户的 ID
    private boolean liked;   // 标识用户是否点赞，true 为点赞，false 为取消点赞
    private Integer timestamp;  // 点赞或取消点赞的时间戳
}