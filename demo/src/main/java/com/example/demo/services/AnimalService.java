package com.example.demo.services;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AnimalEntity;
import com.example.demo.entities.AnimalEntity.Status;
import com.example.demo.repository.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AnimalService {
   @Autowired
    private AnimalRepository animalRepository;

    public AnimalEntity create(AnimalEntity animal) {
        return animalRepository.save(animal);
    }

    public List<AnimalEntity> findAll() {
        return animalRepository.findAll();
    }

    public AnimalEntity changeStatus(Long id, Status newState) {
        AnimalEntity animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animal.setStatus(newState);
        return animalRepository.save(animal);
    }
}
