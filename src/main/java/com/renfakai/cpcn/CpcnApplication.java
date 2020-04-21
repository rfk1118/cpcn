package com.renfakai.cpcn;

import com.renfakai.cpcn.conf.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CpcnApplication {

    public static void main(String[] args) {
        configInit();
        SpringApplication.run(CpcnApplication.class, args);
    }

    private static void configInit() {
        Configuration.init();
    }

}
