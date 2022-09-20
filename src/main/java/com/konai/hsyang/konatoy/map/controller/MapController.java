package com.konai.hsyang.konatoy.map.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MapController {

    @GetMapping("/testmap")
    public String testmap(){

        return "testmap";
    }
}
