package com.meltingpop.melting_pop_1_server.controller;

import com.meltingpop.melting_pop_1_server.DTO.BoardDTO;
import com.meltingpop.melting_pop_1_server.repository.BoardRepository;
import com.meltingpop.melting_pop_1_server.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    //의존성 주입 이슈 : @Autowired로 걸어주던지

    //            public BoardController(BoardService boardService) {
    //              this.boardService = boardService;
    //            }
    //            직접 BoardService 생성자를 사용하여 의존성을 주입해주던지

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("postList",boardDTOList);
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
