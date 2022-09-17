package com.jm.storage;

import com.feiniaojin.ddd.ecosystem.gracefulresponse.EnableGracefulResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhanghongbin
 */
@EnableGracefulResponse
@SpringBootApplication
public class StorageSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageSpringApplication.class, args);
    }
}
