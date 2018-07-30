package com.wecancodeit.comicreviews.demo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ComicRepository extends CrudRepository<Comic, Long> {

	Collection<Comic> findByCategory(Category category);
	
	Collection<Comic> findByCategoryId(Long id);

	Comic findByTitle(String title);

}
