package com.meltingpop.melting_pop_1_server.repository;

import com.meltingpop.melting_pop_1_server.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO,Long> {
    @Query("select u from UserVO u where u.UserID=:UserID and u.UserPW=:UserPW")
    UserVO selectUserInfo(@Param("UserID")String UserID, @Param("UserPW")String UserPW);
}
