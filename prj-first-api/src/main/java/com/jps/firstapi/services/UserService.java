package com.jps.firstapi.services;

import com.jps.firstapi.domain.User;
import com.jps.firstapi.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById (Integer id);

    List<User> findAll();

    User createUser(UserDTO newUserDTO);
}
