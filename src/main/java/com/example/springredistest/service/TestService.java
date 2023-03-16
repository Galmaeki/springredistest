package com.example.springredistest.service;

import com.example.springredistest.StatusDto;
import com.example.springredistest.entity.Status;
import com.example.springredistest.repository.StatusRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final StatusRedisRepository statusRedisRepository;

    @Autowired
    public TestService(StatusRedisRepository statusRedisRepository){
        this.statusRedisRepository = statusRedisRepository;
    }

    public String saveStatus(StatusDto dto) {
        Status status = new Status(dto.email, dto.status);
        statusRedisRepository.save(status);
        return "status"+status.id;
    }

    public List getKeys() {
        List<Status> all = (List<Status>) statusRedisRepository.findAll();
        return all;
    }
}
