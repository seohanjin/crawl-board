package com.example.demo.service.impl;

import com.example.demo.dto.CrawlLogDto;
import com.example.demo.repository.CrawlLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CrawlLogServiceImpl{

    private final CrawlLogRepository crawlLogRepository;

//    @Override
    public Map<String, Object> getCrawlLogList(CrawlLogDto crawlLogDto) {

        int offset = (crawlLogDto.getCurrentPageNum() - 1) * 10;
        crawlLogDto.setOffset(offset);

        int crawlLogTotCnt = crawlLogRepository.getCrawlLogTotCnt();
        List<CrawlLogDto> crawlLogList = crawlLogRepository.getCrawlLogList(crawlLogDto);

//        총 페이지 개수 = Math.ceil(전체 컨텐츠 개수 / 한 페이지에 보여줄 컨텐츠의 개수)
//        화면에 보여질 페이지 그룹 = Math.ceil(현재 페이지 번호 / 한 화면에 보여줄 페이지의 개수)
//        화면에 보여질 페이지의 첫번째 페이지 번호 = ((페이지 그룹 번호 - 1) * 한 화면에 보여줄 페이지의 개수) + 1
//        화면에 보여질 페이지의 마지막 페이지 번호 = 페이지 그룹 번호 * 한 화면에 보여줄 페이지의 개수
//        단, 페이지 그룹 번호 * 한 화면에 보여줄 페이지의 개수가 전체 페이지 개수보다 크다면 전체 페이지가 된다

        // 전체페이지
        int totPageCnt = (int) Math.ceil((double)crawlLogTotCnt / 10);
        // 현재 페이지 번호
        int currentPageNum = crawlLogDto.getCurrentPageNum();
        // 현재 페이지 그룹
        int currentPageGrp = (int) Math.ceil((double)currentPageNum / 5);

        // 현재 그룹의 첫번째 페이지 번호
        int curGrpFirstPageNm = ((currentPageGrp - 1) * 5) + 1;
        // 현재 그룹의 마지막 페이지 번호
        int curGrpLastPageNm = currentPageGrp * 5;
        if (curGrpLastPageNm > totPageCnt) {
            curGrpLastPageNm = totPageCnt;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("totPageCnt", totPageCnt);
        result.put("currentPageNum", currentPageNum);
        result.put("currentPageGrp", currentPageGrp);
        result.put("curGrpFirstPageNm", curGrpFirstPageNm);
        result.put("curGrpLastPageNm", curGrpLastPageNm);
        result.put("crawlList", crawlLogList);

        return result;
    }
}
