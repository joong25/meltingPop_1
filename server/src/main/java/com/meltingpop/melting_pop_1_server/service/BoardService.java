package com.meltingpop.melting_pop_1_server.service;

import com.meltingpop.melting_pop_1_server.DTO.BoardDTO;
import com.meltingpop.melting_pop_1_server.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDTO boardDTO){
        return boardRepository.save(boardDTO.toEntity()).getIdx();
    }
}
