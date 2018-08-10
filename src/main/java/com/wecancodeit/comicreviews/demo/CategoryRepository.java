package com.wecancodeit.comicreviews.demo;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Category findByName( String Name);

	Category findByNameIgnoreCaseLike(String categoryName);

	Tag save(Tag thumbsUp);

}
