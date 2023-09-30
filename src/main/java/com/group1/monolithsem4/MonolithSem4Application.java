package com.group1.monolithsem4;

import com.group1.monolithsem4.service.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.annotation.Resource;

@SpringBootApplication
@ConfigurationPropertiesScan("com.group1.monolithsem4.config")
public class MonolithSem4Application implements CommandLineRunner {

    @Resource
    FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(MonolithSem4Application.class, args);
    }

    @Override
    public void run(String ...arg) throws Exception {
        fileService.init();
    }

}
