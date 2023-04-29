package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.awt.*;

@Configuration        //this will be our configuration
@ComponentScan //it will scan all sub packages starting from "com.tpe"
@PropertySource("classpath:application.properties")
public class AppConfiguration {


    @Bean
    public Point point(){
        return new Point(25, 35);
    }


}
