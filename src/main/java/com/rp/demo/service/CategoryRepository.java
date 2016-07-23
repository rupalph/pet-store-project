package com.rp.demo.service;

 

import org.springframework.data.jpa.repository.JpaRepository;


import com.rp.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
	
}
