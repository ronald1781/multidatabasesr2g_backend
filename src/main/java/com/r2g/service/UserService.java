package com.r2g.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r2g.model.bdmq.User;
import com.r2g.repo.bdmq.IRepo_bdmq;

@Service

public class UserService {
    @Autowired
    private IRepo_bdmq repomq;

    public void registrar(User u) {
        repomq.save(u);
    }
}
