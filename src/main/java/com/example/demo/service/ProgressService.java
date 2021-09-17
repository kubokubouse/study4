package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Progress;
import com.example.demo.repository.ProgressRepository;

@Service
public class ProgressService
{
    @Autowired
    ProgressRepository progressRepository;

    public List<Progress> findAll()
    {
        return progressRepository.findAll();
    }

    public List <Progress> findUserid(int userid)
    {
    	return progressRepository.findByUserid(userid);
    }

    public Progress findUseridStudyid(int userid, int studyid)
    {
    return progressRepository.findByUseridAndStudyid(userid, studyid);
    }

    public Progress updateProgress(Progress progress) {
        return progressRepository.save(progress);
    }


}