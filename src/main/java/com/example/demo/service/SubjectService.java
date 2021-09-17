package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectService
{
    @Autowired
    SubjectRepository subjectRepository;

    /*public List<Progress> findAll()
    {
        return progressRepository.findAll();
    }*/

   /* public List <Progress> findUserid(int userid)
    {
    	return progressRepository.findByUserid(userid);
    }*/

    public Subject findId(int id)
    {
    return subjectRepository.findById(id);
    }
}