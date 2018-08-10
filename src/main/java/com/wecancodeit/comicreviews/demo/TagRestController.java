package com.wecancodeit.comicreviews.demo;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagRestController {
	
	@Resource
	private TagRepository tagRepo;
	
	@Resource
	private ComicRepository comicRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@RequestMapping()
	public Iterable<Comic>findAllComics() {
		return comicRepo.findAll();
	}
	
	@RequestMapping("/{id}")
	public Optional<Comic>findOneComic(@PathVariable long id) {
		return comicRepo.findById(id);
	}
	
	@RequestMapping("/category/{categoryName}")
	public Collection<Comic>findAllComicsByCategory(@PathVariable(value = "categoryName")String categoryName ) {
		Category category = categoryRepo.findByNameIgnoreCaseLike(categoryName);
		return comicRepo.findByCategory(category);
	}

	
	
}
