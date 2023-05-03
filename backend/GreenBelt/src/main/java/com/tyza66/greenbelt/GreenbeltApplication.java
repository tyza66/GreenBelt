package com.tyza66.greenbelt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@MapperScan("com.tyza66.greenbelt.mapper")
public class GreenbeltApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenbeltApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate build = builder.build();
        return build;
    }

    @Bean
    public Jedis jedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("000415");
        return jedis;
    }
}
