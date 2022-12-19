package com.example.finalprojecthabibbackend.repository;

import com.example.finalprojecthabibbackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
