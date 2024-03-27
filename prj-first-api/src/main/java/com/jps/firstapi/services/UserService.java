package com.jps.firstapi.services;

import com.jps.firstapi.domain.User;

import java.util.List;

public interface UserService {

    User findById (Integer id);

    List<User> findAll();
}
