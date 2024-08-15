package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}