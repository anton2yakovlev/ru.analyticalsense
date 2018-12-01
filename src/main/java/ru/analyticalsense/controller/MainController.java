package ru.analyticalsense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Map<String, Object> model) {

        return "main";
    }

}
