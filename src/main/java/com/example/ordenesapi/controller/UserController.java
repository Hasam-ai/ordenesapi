package com.example.ordenesapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.ordenesapi.repository.UserRepository;
import com.example.ordenesapi.mapper.UserMapper;
import com.example.ordenesapi.dto.request.UserRequest;
import com.example.ordenesapi.dto.response.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;
    private final UserMapper mapper;

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .toList();
    }
}