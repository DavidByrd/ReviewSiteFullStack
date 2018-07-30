package com.wecancodeit.comicreviews.demo;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
	
	@Resource
	private ComicRepository comicRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@RequestMapping()
	public Iterable<Category>findAllCategories() {
		return categoryRepo.findAll();
	}

}
