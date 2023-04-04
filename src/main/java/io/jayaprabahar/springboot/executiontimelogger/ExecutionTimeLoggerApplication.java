package io.jayaprabahar.springboot.executiontimelogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ExecutionTimeLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExecutionTimeLoggerApplication.class, args);
    }

}
