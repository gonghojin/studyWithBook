package com.react.api.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
    @Id
    @GeneratedValue
    private Long _idx;
    private String title;
    private String body;
    private String[] tags;

    public Post(String title, String body, String[] tags) {
        this.title = title;
        this.body = body;
        this.tags = tags;
    }
}