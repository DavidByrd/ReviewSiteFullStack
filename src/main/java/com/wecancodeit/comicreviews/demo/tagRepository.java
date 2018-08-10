package com.wecancodeit.comicreviews.demo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;




public interface TagRepository extends CrudRepository<Tag,Long > {
	
Collection<Tag> findByCategory(Category category);
	
	Collection<Tag> findByCategoryId(Long id);

	Comic findByName(String name);


}
