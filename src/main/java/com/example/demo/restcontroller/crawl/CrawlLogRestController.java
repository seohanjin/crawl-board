package com.example.demo.restcontroller.crawl;

import com.example.demo.dto.crawl.CrawlLogDto;
import com.example.demo.service.crawl.CrawlLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CrawlLogRestController {

    private final CrawlLogService crawlLogService;

    @GetMapping("/crawl")
    public Map<String, Object> getCrawlLogList(CrawlLogDto crawlLogDto) {

        Map<String, Object> result = crawlLogService.getCrawlLogList(crawlLogDto);
        return result;
    }
}
