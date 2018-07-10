package com.wecancodeit.comicreviews.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class JPAMappingsTest {
	
	@Resource
	private TestEntityManager entityManager;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private ComicRepository comicRepo;
	
	@Resource
	private IssueRepository issueRepo;
	
	@Test
	public void shouldBeABleToSaveAndLoadCategory() {
		Category category = categoryRepo.save(new Category("category", null, null));
		long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Category>result = categoryRepo.findById(categoryId);
		category =result.get();
		assertThat(category.getName(), is("category"));
		
	}
	
	@Test
	public void shouldGenerateCategoryById() {
		Category category = categoryRepo.save(new Category("category", null, null));
		long categoryId = category.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(categoryId, is(greaterThan(0L)));
		
		
		}
	
	@Test
	public void shouldSaveAndLoadComic() {
		Comic comic = new Comic("title", "description", null, null);
		comic = comicRepo.save(comic);
		long id = comic.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Comic>result = comicRepo.findById(id);
		comic =result.get();
		assertThat(comic.getTitle(),is("title"));
		
		
		}
	
	@Test
	public void shouldEstablishCategoryToComicsRelationship() {
		Category category = new Category("Mature", "description");
		category = categoryRepo.save(category);
		long categoryId = category.getId();
		
		Comic spiderman = comicRepo.save(new Comic("SpiderMan", null, null, category));
		Comic saga = comicRepo.save(new Comic("Saga", null, null, category));
		Comic invincible = comicRepo.save(new Comic("Invincible", null, null, category));
		Comic sandman = comicRepo.save(new Comic("SandMan", null, null, category));
		
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Category>result = categoryRepo.findById(categoryId);
		category = result.get();
		
		assertThat(category.getComics(),containsInAnyOrder(saga,sandman,spiderman,invincible));
		
		
		
		}
	
	@Test
	public void shoulFindComicsForCategory() {
		Category mature = categoryRepo.save(new Category("Mature", "description"));
		
	Comic sandman = comicRepo.save(new Comic("Saga", "description", "review", mature));
	Comic saga = comicRepo.save(new Comic("Saga", "description", "review", mature));
	
	entityManager.flush();
	entityManager.clear();
	
	Collection<Comic> comicsForCategory = comicRepo.findByCategoryContains(mature);
	
	assertThat(comicsForCategory, containsInAnyOrder(sandman, saga));
	
	

	}
	
	@Test
	public void shoulFindComicsForCategoryId() {
		Category teen = categoryRepo.save(new Category("Teen", "description"));
		long categoryId = teen.getId();
		
	Comic invincible = comicRepo.save(new Comic("Invincible","description", "review", teen));
	Comic chew = comicRepo.save(new Comic("Chew", "description", "review", teen));
	
	entityManager.flush();
	entityManager.clear();
	
	Collection<Comic> comicForCategory = comicRepo.findByCategoryId(categoryId);
	
	assertThat(comicForCategory, containsInAnyOrder(invincible, chew));
	
	}
	
	@Test
	public void shouldEstablishIssueToComicRelationship() {
		Comic comic = new Comic();
		comicRepo.save(comic);
		long comicId = comic.getId();
		
		Issue issue = new Issue("number", comic);
		issueRepo.save(issue);
		
		Issue issue2 = new Issue("number2", comic);
		issueRepo.save(issue2);
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Comic> result =comicRepo.findById(comicId);
		comic = result.get();
		assertThat(comic.getIssues(), containsInAnyOrder(issue, issue2));
		
		
		
		

		
	}
	

}
