package com.example.ordenesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ordenesapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}