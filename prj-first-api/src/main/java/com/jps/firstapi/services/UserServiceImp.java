package com.jps.firstapi.services;

import com.jps.firstapi.domain.User;
import com.jps.firstapi.domain.dto.UserDTO;
import com.jps.firstapi.repositories.UserRepository;
import com.jps.firstapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO newUserDTO) {
        return userRepository.save(mapper.map(newUserDTO, User.class));
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("The object not found."));
    }
}
