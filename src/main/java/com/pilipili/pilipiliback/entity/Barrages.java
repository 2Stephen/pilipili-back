package com.pilipili.pilipiliback.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Barrages")
public class Barrages {
    @Id
    private String key;
    @JsonIgnore
    private Integer videoid;
    private String text;
    private Integer time;
    private String color;
}
