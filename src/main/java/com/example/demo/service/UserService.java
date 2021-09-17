package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService
{
    @Autowired
    UserRepository UserRepository;

    //ポイント①
    public User findEmailPassword(String emil, String password)
    {
    	return UserRepository.findByEmailAndPassword(emil,password);
    }

    /*public List<User> findAll() {
        return UserRepository.findAllOrderById();
    }*/

    public void insert(User user)
    {
        UserRepository.save(user);
    }

    public void update(User user)
    {
        UserRepository.save(user);
    }

    public User updateUser(User user)
    {
        return UserRepository.save(user);
    }

   /* public void delete(Integer id) {
        UserRepository.deleteById(id);
    }

    //public Optional<User> selectById(Integer id) {
        return UserRepository.findById(id);
    }*/
}