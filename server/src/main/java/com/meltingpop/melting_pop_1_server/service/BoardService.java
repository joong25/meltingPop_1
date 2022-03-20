package com.meltingpop.melting_pop_1_server.service;

import com.meltingpop.melting_pop_1_server.DTO.BoardDTO;
import com.meltingpop.melting_pop_1_server.repository.BoardRepository;
import com.meltingpop.melting_pop_1_server.vo.BoardVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    // @Transactional 어노테이션
    // 트랜잭션 : 데이터베이스 상태를 변경하는 작업 또는 한번에 수행되어야 하는 연산을 의미
    // begin과 commit을 자동으로 수행해준다.
    // @Transactional을 메소드, 클래스, 인터페이스 위에 추가하여 사용하면
    // 트랜잭션 기능이 포함된 프록시 객체가 생성되어 자동으로 commit 혹은 rollback을 진행해준다.

    // 글쓰기 Form에서 내용을 입력한 뒤, '글쓰기' 버튼을 누르면 Post 형식으로 요청이 오고
    // BoardService의 savePost()를 실행하게 된다.
    @Transactional
    public Long savePost(BoardDTO boardDTO){
        return boardRepository.save(boardDTO.toEntity()).getIdx();
    }

    // 게시물의 목록을 가져오는 getBoardList 구현하기
    // Repository에서 모든 데이터를 조회하여, BoardDTO List에 데이터를 넣어 반환한다
    @Transactional
    public List<BoardDTO> getBoardList(){
        List<BoardVO> boardVOList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for(BoardVO boardVO : boardVOList){
            BoardDTO boardDTO = BoardDTO.builder()
                    .idx(boardVO.getIdx())
                    .author(boardVO.getAuthor())
                    .title(boardVO.getTitle())
                    .content(boardVO.getContent())
                    .createdDate(boardVO.getCreatedDate())
                    .build();
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }
}
