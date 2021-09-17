package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Targetuniver;
import com.example.demo.repository.TargetuniverRepository;

@Service
public class TargetuniverService {
    @Autowired
    TargetuniverRepository targetuniverRepository;

    public List<Targetuniver> findAll()
    {
        return targetuniverRepository.findAll();
    }

    public List <Targetuniver> findStudyid(int id)
    {
    	return targetuniverRepository.findByTargetid(id);
    }

    public Targetuniver findTargetidSubjectid(int targetid,int subjectid)
    {
    return targetuniverRepository.findByTargetidAndSubjectid(targetid, subjectid);
    }


}