package com.accounting_of_costumes.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TestController {
    private static Set<TestItemRecordData> itemDTOS=new HashSet<>();

    @GetMapping("/test")
    public String testC(Model model){
        model.addAllAttributes(Map.of("some","Hello!"))
                .addAttribute("item",new TestItemRecordData(0L,"test"));
        return "test_page";
    }
    @PostMapping("/test")
    public String testP(@ModelAttribute TestItemRecordData data, Model model){
        itemDTOS.add(data);
        model.addAttribute("items", itemDTOS)
                .addAttribute("some","No!")
                .addAttribute("item", new TestItemRecordData(0L,"test"));
        return "test_page";
    }
}
