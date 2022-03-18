package com.meltingpop.melting_pop_1_server.controller;

import com.meltingpop.melting_pop_1_server.DTO.BoardDTO;
import com.meltingpop.melting_pop_1_server.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public String list(){
        return "templates/board/list";
    }

    @GetMapping("/post")
    public String post(){
        return "templates/board/post";
    }

    @PostMapping("/post")
    public String write(BoardDTO boardDTO){
        boardService.savePost(boardDTO);
        return "redirect:/";
    }
}
