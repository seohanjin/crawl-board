package com.example.demo.restcontroller.slot;

import com.example.demo.dto.slot.SlotDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
@Slf4j
public class SlotRestController {

    @PostMapping("/list")
    public int updateSlotData(@RequestBody List<SlotDto> slotDto) {
        log.info("slotDto :: " + slotDto);
        return 0;
    }
}
