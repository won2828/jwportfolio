package com.jwportfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    private Long id;
    private String title;
    private String category;
    private String thumbnailUrl;
    private List<String> images;
    private String description;
    private String client;
    private String duration;
}
