package com.r2g.repo.bdmq;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2g.model.bdmq.User;

public interface IRepo_bdmq extends JpaRepository<User, Integer> {

}
