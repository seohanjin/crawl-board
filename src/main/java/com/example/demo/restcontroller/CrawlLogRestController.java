package com.example.demo.restcontroller;

import com.example.demo.Entity.CrawlLog;
import com.example.demo.dto.CrawlLogDto;
import com.example.demo.repository.CrawlLogRepository;
import com.example.demo.service.impl.CrawlLogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CrawlLogRestController {

    private final CrawlLogServiceImpl crawlLogService;

    @GetMapping("/crawl")
    public Map<String, Object> getCrawlLogList(CrawlLogDto crawlLogDto) {

        Map<String, Object> result = crawlLogService.getCrawlLogList(crawlLogDto);
        return result;
    }
}
