package com.staff.staffAttendance.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class BeanConfig {

    @Bean
    public MappingJackson2JsonView jsonView() {
    	return new MappingJackson2JsonView();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}


