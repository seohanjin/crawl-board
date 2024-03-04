package com.example.demo.mapper.crawl;

import com.example.demo.dto.crawl.CrawlLogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CrawlLogMapper {

    List<CrawlLogDto> getCrawlLogList(CrawlLogDto crawlLogDto);
    int getCrawlLogTotCnt();
}
