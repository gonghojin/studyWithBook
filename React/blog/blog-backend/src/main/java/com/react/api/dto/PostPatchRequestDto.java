package com.react.api.dto;

import lombok.Data;

@Data
public class PostPatchRequestDto {
  private String title;
  private String body;
  private String[] tags;
}
