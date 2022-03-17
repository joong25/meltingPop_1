package com.meltingpop.melting_pop_1_server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoinController {
    @GetMapping("/join")
    public String signup(){
        return "templates/SignUp";
    }
}
