package com.example.finalprojecthabibbackend.repository;

import com.example.finalprojecthabibbackend.model.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
