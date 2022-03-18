package com.meltingpop.melting_pop_1_server.repository;

import com.meltingpop.melting_pop_1_server.vo.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardVO, Long> {

}
