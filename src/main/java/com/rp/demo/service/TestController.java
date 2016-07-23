package com.rp.demo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rp.demo.model.Category;
import com.rp.demo.model.Pet;
import com.rp.demo.model.PetStoreAppException;
import com.rp.demo.model.Tag;

@RestController
@RequestMapping("/petworld/api")
public class TestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PetService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;

	@RequestMapping(method = RequestMethod.GET, value = "/pet")
	List<Pet> findAll() {
		return service.findAll();
	}

	@RequestMapping( method = RequestMethod.POST, value = "/pet")
	public Pet create(@RequestBody  Pet pet) {
		log.debug("Received request to create the {}", pet);

		return service.save(pet);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/pet/{id}")
	public Pet update(@PathVariable long id,@RequestBody @Valid final Pet pet) {
		log.debug("Received request to update the {}", pet);

		return service.update(id,pet);


	}

	@RequestMapping(method=RequestMethod.DELETE, value="/pet/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		log.debug("Received request to delete the {}", id);
		service.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/category")
	public List<Category> listCategory() {
		
		return categoryService.listAllCategories();

	}
	
	@RequestMapping(method=RequestMethod.GET, value="/tag")
	public List<Tag> listTag() {
		
		return tagService.listAllTags();

	}

	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
	void handleBadRequests(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}