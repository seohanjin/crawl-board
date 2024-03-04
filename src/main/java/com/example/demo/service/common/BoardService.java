package com.example.demo.service.common;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoardService {

    public Map<String, Object> setBoardInfo(int totCnt, int curPageNum) {

//        총 페이지 개수 = Math.ceil(전체 컨텐츠 개수 / 한 페이지에 보여줄 컨텐츠의 개수)
//        화면에 보여질 페이지 그룹 = Math.ceil(현재 페이지 번호 / 한 화면에 보여줄 페이지의 개수)
//        화면에 보여질 페이지의 첫번째 페이지 번호 = ((페이지 그룹 번호 - 1) * 한 화면에 보여줄 페이지의 개수) + 1
//        화면에 보여질 페이지의 마지막 페이지 번호 = 페이지 그룹 번호 * 한 화면에 보여줄 페이지의 개수
//        단, 페이지 그룹 번호 * 한 화면에 보여줄 페이지의 개수가 전체 페이지 개수보다 크다면 전체 페이지가 된다

        // 전체페이지
        int totPageCnt = (int) Math.ceil((double)totCnt / 10);

        // 현재 페이지 그룹
        int currentPageGrp = (int) Math.ceil((double)curPageNum / 5);

        // 현재 그룹의 첫번째 페이지 번호
        int curGrpFirstPageNm = ((currentPageGrp - 1) * 5) + 1;
        // 현재 그룹의 마지막 페이지 번호
        int curGrpLastPageNm = currentPageGrp * 5;
        if (curGrpLastPageNm > totPageCnt) {
            curGrpLastPageNm = totPageCnt;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("totPageCnt", totPageCnt);
        result.put("curPageNum", curPageNum);
        result.put("currentPageGrp", currentPageGrp);
        result.put("curGrpFirstPageNm", curGrpFirstPageNm);
        result.put("curGrpLastPageNm", curGrpLastPageNm);

        return result;
    }
}
