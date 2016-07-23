package com.rp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rp.demo.model.Pet;
@Component
public class PetService {

	@Autowired
	private  PetRepository repository;
	
	List<Pet> findAll() {
        return (List<Pet>) repository.findAll();
    }

	public Pet save(Pet pet) {
		return repository.save(pet);
	}

	public Pet update(long id, Pet pet) {
		
	       Pet p=repository.findOne(id);
	       
	       p.copy(pet);
	       return repository.save(p);
	}

	public void delete(long id) {

	       repository.delete(id);
	}
}
