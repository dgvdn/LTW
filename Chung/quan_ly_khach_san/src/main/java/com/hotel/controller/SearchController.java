package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String search(@ModelAttribute("checkin") String checkin ,@ModelAttribute("checkout") String checkout){
//        System.out.println(checkin + " " +  checkout);
        String s = checkin + " " +  checkout;
        String[] arr = s.split(" ");
        String in = arr[0];
        String[] inrr = in.split("/");
        String realin = inrr[2]+"-"+inrr[0]+"-"+inrr[1];
        String out = arr[3];
        String[] outrr = out.split("/");
        String realout = outrr[2]+"-"+outrr[0]+"-"+outrr[1];
        System.out.println(realin + " " + realout);
        return "home";

    }
}
