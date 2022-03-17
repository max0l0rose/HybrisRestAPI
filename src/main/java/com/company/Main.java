package com.company;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

// https://github.com/maxanarki2/SpringShellTest

@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
@PropertySource("classpath:local.properties")
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    public static void main(String[] args) {
        log.info("main: ----------------------------");
//        try {
            SpringApplication.run(Main.class, args);
//        } catch (IllegalStateException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
        log.info("main: ===========================!");
    }
}

