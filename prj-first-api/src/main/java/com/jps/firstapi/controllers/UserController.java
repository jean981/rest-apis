package com.jps.firstapi.controllers;

import com.jps.firstapi.domain.dto.UserDTO;
import com.jps.firstapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){

        return ResponseEntity.ok().body(
                userService.findAll()
                    .stream()
                    .map((u) -> mapper.map(u, UserDTO.class))
                    .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(mapper.map(userService.findById(id),UserDTO.class));
    }

}
