package com.wecancodeit.comicreviews.demo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;




public interface tagRepository<T> extends CrudRepository<Tags,Long > {
	
Collection<Tags> findByCategory(Category category);
	
	Collection<Tags> findByCategoryId(Long id);

	Comic findByName(String name);


}
