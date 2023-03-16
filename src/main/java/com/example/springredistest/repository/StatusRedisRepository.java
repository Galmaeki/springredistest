package com.example.springredistest.repository;

import com.example.springredistest.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRedisRepository extends CrudRepository<Status, String> {
    List<Status> findAllByIdIsNotNull();
}
