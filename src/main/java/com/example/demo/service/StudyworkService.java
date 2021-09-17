package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Studywork;
import com.example.demo.repository.StudyworkRepository;

@Service
public class StudyworkService
{
    @Autowired
    StudyworkRepository studyworkRepository;

    public List<Studywork> findAll()
    {
        return studyworkRepository.findAll();
    }

    public Studywork findById(int id)
    {
    	return studyworkRepository.findById(id);
    }

}