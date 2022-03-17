package com.meltingpop.melting_pop_1_server.repository;

import com.meltingpop.melting_pop_1_server.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO,Long> {
}
