package com.example.demo.repository;

import com.example.demo.Entity.CrawlLog;
import com.example.demo.dto.CrawlLogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrawlLogRepository {

    List<CrawlLogDto> getCrawlLogList(CrawlLogDto crawlLogDto);
    int getCrawlLogTotCnt();
}
