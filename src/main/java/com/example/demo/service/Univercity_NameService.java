package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Univercity_Name;
import com.example.demo.repository.Univercity_NameRepository;

@Service
public class Univercity_NameService
{
    @Autowired
    Univercity_NameRepository univercity_NameRepository;

    public Univercity_Name findId(int id)
    {
    return univercity_NameRepository.findById(id);
    }
}