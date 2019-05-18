package com.react.api.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long _idx;
    private String title;
    private String body;
    private String[] tags;

}