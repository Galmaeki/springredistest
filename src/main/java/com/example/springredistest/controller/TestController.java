package com.example.springredistest.controller;

import com.example.springredistest.StatusDto;
import com.example.springredistest.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @PostMapping("/api")//데이터 저장
    public String makeStatus(@RequestBody StatusDto dto){
        return testService.saveStatus(dto);
    }

    @GetMapping("/api")
    public List getKeys(){
        return testService.getKeys();
    }
}
