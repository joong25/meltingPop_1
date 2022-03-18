package com.meltingpop.melting_pop_1_server.service;

import com.meltingpop.melting_pop_1_server.repository.UserRepository;
import com.meltingpop.melting_pop_1_server.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void joinUser(UserVO vo){
        userRepository.save(vo);
    }

    public UserVO loginUser(String UserId, String UserPW){
        UserVO userVO = userRepository.selectUserInfo(UserId,UserPW);
        return userVO;
    }

}
