package com.example.demo.controller.slot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/slot")
public class SlotController {

    @GetMapping("/list")
    public String getSlotList(@RequestParam(value = "id", required = false) Long id, Model model) {
        model.addAttribute("id", id);
        return "slot/slot_list";
    }
}
