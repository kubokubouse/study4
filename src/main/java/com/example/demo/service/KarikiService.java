package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Kariki;
import com.example.demo.repository.KarikiRepository;

@Service
public class KarikiService {
    @Autowired
    KarikiRepository karikiRepository;

    public List <Kariki> findId(int id)
    {
    	return karikiRepository.findByUserid(id);
    }





}