package com.rp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rp.demo.model.Tag;

@Component
public class TagService {

	@Autowired
	private TagRepository repository;
	
	public List<Tag> listAllTags()
	{
		return repository.findAll();
	}
}
