package com.example.university.service.impl;

import com.example.university.model.University;
import com.example.university.repository.IUniversityRepository;
import com.example.university.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService implements IUniversityService {
    @Autowired
    private IUniversityRepository universityRepository;
    @Override
    public List<University> all() {
        return universityRepository.findAll();
    }

    @Override
    public University getById(String id) {
        return universityRepository.findById(id).get();
    }

    @Override
    public University add(University faculty) {
        return universityRepository.save(faculty);
    }

    @Override
    public University update(University faculty) {
        return universityRepository.save(faculty);
    }

    @Override
    public void delete(String id) {
            universityRepository.deleteById(id);
    }
}
