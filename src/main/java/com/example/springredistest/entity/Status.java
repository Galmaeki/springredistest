package com.example.springredistest.entity;

import com.example.springredistest.StatusDto;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "status")
public class Status {

    @Id
    public String id;
    public String email;
    public String status;
    public LocalDateTime createdAt;

    public Status(String email, String status){
        this.email=email;
        this.status=status;
        this.createdAt=LocalDateTime.now();
    }
}
