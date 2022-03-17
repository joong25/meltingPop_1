package com.meltingpop.melting_pop_1_server.controller;

import com.meltingpop.melting_pop_1_server.service.UserService;
import com.meltingpop.melting_pop_1_server.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/joinUs.do", method= RequestMethod.POST)
    public String joinUs(UserVO vo){
        userService.joinUser(vo);
        return "static/index";
    }
}
