package com.example.demo.dto.crawl;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CrawlLogDto {

    private int limit;
    private int offset;

    private Long Id;
    private String content;
    private String createdAt;

    private int totCnt;
    private int currentPageNum;

}
