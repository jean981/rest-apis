package com.jps.firstapi.config;

import com.jps.firstapi.domain.User;
import com.jps.firstapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    UserRepository userRepository;
    @Bean
    public List<User> startDb(){
        User us1 = new User(null,"joao","joao@gmail.com", "123");
        User us2 = new User(null,"jose","jose@gmail.com", "123");

       return userRepository.saveAll(List.of(us1,us2));
    }
}
