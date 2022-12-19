package com.example.finalprojecthabibbackend.repository;

import com.example.finalprojecthabibbackend.model.entity.WorkPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<WorkPermission, Long> {
}
