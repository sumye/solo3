package com.sparta.solo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class Solo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Solo3Application.class, args);
    }


//    @PostConstruct
//    public void started() {
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
//    }
}
