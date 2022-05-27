    package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/room")
    public String room() {
        return "room";
    }
    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/service")
    public String service() {
        return "service";
    }
    @GetMapping("/team")
    public String team() {
        return "team";
    }
    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }


}