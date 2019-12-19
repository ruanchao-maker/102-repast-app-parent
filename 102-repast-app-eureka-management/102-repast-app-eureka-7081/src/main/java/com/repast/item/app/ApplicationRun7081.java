package com.repast.item.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 20:43
 * @description ：
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun7081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun7081.class,args);
    }

}
