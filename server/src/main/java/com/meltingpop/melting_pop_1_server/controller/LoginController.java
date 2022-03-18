package com.meltingpop.melting_pop_1_server.controller;

import com.meltingpop.melting_pop_1_server.service.UserService;
import com.meltingpop.melting_pop_1_server.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, Model model){
        System.out.println("vo="+vo);
        // userService의
        UserVO userVO = userService.loginUser(vo.getUserID(), vo.getUserPW());
        if(userVO == null){
            model.addAttribute("loginMessage","아이디 혹은 비밀번호가 일치하지 않습니다.");
            return "static/index";
        }
        model.addAttribute("userEmail",userVO.getUserEmail());
        return "templates/main";
    }
}
