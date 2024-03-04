package com.example.demo.controller.crawl;

import com.example.demo.service.crawl.CrawlLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CrawlLogController {

    private final CrawlLogService crawlLogService;

    @GetMapping("/crawlLog")
    public String crawlLog() {

//        Map<String, Object> result = crawlLogService.getCrawlLogList(crawlLogDto);
//        model.addAttribute("results", result);

        return "tables";
    }
}
