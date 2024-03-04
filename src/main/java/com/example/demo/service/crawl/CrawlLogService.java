package com.example.demo.service.crawl;

import com.example.demo.dto.crawl.CrawlLogDto;
import com.example.demo.mapper.crawl.CrawlLogMapper;
import com.example.demo.service.common.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CrawlLogService {

    private final CrawlLogMapper crawlLogMapper;
    private final BoardService boardService;

    public Map<String, Object> getCrawlLogList(CrawlLogDto crawlLogDto) {

        int offset = (crawlLogDto.getCurrentPageNum() - 1) * 10;
        crawlLogDto.setOffset(offset);

        int crawlLogTotCnt = crawlLogMapper.getCrawlLogTotCnt();
        List<CrawlLogDto> crawlLogList = crawlLogMapper.getCrawlLogList(crawlLogDto);

        Map<String, Object> boardInfo = boardService.setBoardInfo(crawlLogTotCnt, crawlLogDto.getCurrentPageNum());

        boardInfo.put("crawlList", crawlLogList);

        return boardInfo;
    }
}
