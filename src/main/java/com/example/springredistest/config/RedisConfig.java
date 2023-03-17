package com.example.springredistest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        //추가된 부분
        RedisStandaloneConfiguration rds = new RedisStandaloneConfiguration();
        rds.setHostName(host);
        rds.setPort(port);
        rds.setPassword(password);
        //추가된 부분
        return new LettuceConnectionFactory(rds);
//        return new LettuceConnectionFactory(host,port);
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(){
        RedisTemplate<?,?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}
