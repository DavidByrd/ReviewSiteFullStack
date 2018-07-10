package com.wecancodeit.comicreviews.demo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ComicControllerTest {
	
	
	@InjectMocks
	private NewComicController underTest;
	
	@Mock
	private Comic comic;
	
	@Mock
	private Category category;
	
	@Mock
	private Comic anotherComic;
	
	@Mock
	private Category anotherCategory;
	
	@Mock
	private ComicRepository comicRepo;
	
	@Mock
	private CategoryRepository categoryRepo;
	
	@Mock
	private Model model;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		
	}
	@Test
	public void shouldAddSingleComicToModel() throws ComicNotFoundException {
		long arbitraryComicId = 1;
		when(comicRepo.findById(arbitraryComicId)).thenReturn(Optional.of(comic));
		
		underTest.findOneComic(arbitraryComicId, model);
		verify(model).addAttribute("comics", comic);
		
		
		}
	
	@Test
	public void shouldAddAllComicsToModel() {
		Collection<Comic> allComics = Arrays.asList(comic, anotherComic);
		when(comicRepo.findAll()).thenReturn(allComics);
		
		underTest.findAllComics(model);
		verify(model).addAttribute("comics", allComics);
		
	}
	
	@Test
	public void shouldAddSingleCategoryTOModel() throws CategoryNotFoundException {
		long arbitraryCategoryId = 1;
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		
		underTest.findOneCategory(arbitraryCategoryId, model);
		
		verify(model).addAttribute("categorys", category);
		
		
		}
	
	@Test
	public void shouldAddAllCategorysToModel() {
		Collection<Category>allCategorys = Arrays.asList(category, anotherCategory);
		when(categoryRepo.findAll()).thenReturn(allCategorys);
		
		underTest.findAllCategorys(model);
		verify(model).addAttribute("categorys", allCategorys);
		
	}
}
