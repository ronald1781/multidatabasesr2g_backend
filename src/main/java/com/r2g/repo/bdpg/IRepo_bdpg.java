package com.r2g.repo.bdpg;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r2g.model.bdpg.Product;

public interface IRepo_bdpg extends JpaRepository<Product, Integer> {

}
