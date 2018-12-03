package ru.analyticalsense.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String main(Map<String, Object> model) {

        return "profile";
    }
}
