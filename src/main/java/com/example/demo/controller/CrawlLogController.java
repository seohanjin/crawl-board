package com.example.demo.controller;

import com.example.demo.dto.CrawlLogDto;
import com.example.demo.service.impl.CrawlLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CrawlLogController {

    private final CrawlLogServiceImpl crawlLogService;

    @GetMapping("/crawlLog")
    public String crawlLog(CrawlLogDto crawlLogDto, Model model) {

//        Map<String, Object> result = crawlLogService.getCrawlLogList(crawlLogDto);
//        model.addAttribute("results", result);

        return "tables";
    }
}
