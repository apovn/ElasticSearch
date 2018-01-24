package com.kodcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Ref: https://dzone.com/articles/elasticsearch-java-api

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ElasticSearchStarter {
    public static void main(String[] args){
        SpringApplication.run(ElasticSearchStarter.class, args);
    }
}
