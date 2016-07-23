package com.rp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.rp.demo.model.Category;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> listAllCategories()
	{
		return repository.findAll();
	}

}
