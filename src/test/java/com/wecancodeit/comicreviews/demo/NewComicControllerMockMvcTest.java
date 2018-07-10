package com.wecancodeit.comicreviews.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(NewComicController.class)
public class NewComicControllerMockMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private ComicRepository comicRepo;
	
	@MockBean
	private CategoryRepository categoryRepo;
	
	@Mock
	private Comic comic;
	
	@Mock
	private Comic anotherComic;
	
	@Mock
	Category category;
	
	@Mock
	Category anotherCategory;
	
	@Test
	public void shouldRoutToSingleComicView() throws Exception {
		long arbitraryComicId = 1;
		when(comicRepo.findById(arbitraryComicId)).thenReturn(Optional.of(comic));
		mvc.perform(get("/comic?id=1")).andExpect(view().name(is("comic")));
	}
	
	@Test
	public void shouldBeOkForSingleComic() throws Exception {
		long arbitraryComicId = 1;
		when(comicRepo.findById(arbitraryComicId)).thenReturn(Optional.of(comic));
		mvc.perform(get("/comic?id=1")).andExpect(status().isOk());	
		
	}
	
	@Test
	public void shouldNotBeOkForSingleComic() throws Exception {
		
		mvc.perform(get("/comic?id=1")).andExpect(status().isNotFound());	
		
	}
	
	@Test
	public void shouldPutSingleComicIntoModel() throws Exception {
		when(comicRepo.findById(1L)).thenReturn(Optional.of(comic));
		
		mvc.perform(get("/comic?id=1")).andExpect(model().attribute("comics", is(comic)));
	}
	
	@Test
	public void shouldRouteToAllComicsView() throws Exception {
		mvc.perform(get("/show-comics")).andExpect(view().name(is("comics")));
		

	}
	
	@Test
	public void shouldBeOkForAllComics() throws Exception {
		mvc.perform(get("/show-comics")).andExpect(status().isOk());	

		
	}
	
	@Test
	public void shouldPutAllComicIntoModel() throws Exception {
		Collection<Comic> allComics = Arrays.asList(comic, anotherComic);
		when(comicRepo.findAll()).thenReturn(allComics);
		
		mvc.perform(get("/show-comics")).andExpect(model().attribute("comics", is(allComics)));
	}
	
	@Test
	public void shoudRouteToSingleCategoryView() throws Exception {
		long arbitraryCategoryId = 20;
		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=20")).andExpect(view().name(is("category")));
		
//		@Test
//		public void shouldRoutToSingleComicView() throws Exception {
//			long arbitraryComicId = 1;
//			when(comicRepo.findById(arbitraryComicId)).thenReturn(Optional.of(comic));
//			mvc.perform(get("/comic?id=1")).andExpect(view().name(is("comic")));
		
	}
	
	@Test
	public void shouldBeOkForSingleCategory() throws Exception {
		long arbitraryCategoryId = 20;

		when(categoryRepo.findById(arbitraryCategoryId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=20")).andExpect(status().isNotFound());
		
//		mvc.perform(get("/comic?id=1")).andExpect(status().isNotFound());	
		
	}
	
	@Test
	public void shouldPutSingleCategoryIntoModel() throws Exception {
		when(categoryRepo.findById(20L)).thenReturn(Optional.of(category));
		
		mvc.perform(get("/category?id=20")).andExpect(model().attribute("categorys", is(category)));
		
//		public void shouldPutSingleComicIntoModel() throws Exception {
//			when(comicRepo.findById(1L)).thenReturn(Optional.of(comic));
//			
//			mvc.perform(get("/comic?id=1")).andExpect(model().attribute("comics", is(comic)));
		
		
		
	}
	
	@Test
	public void shouldBeOkayForAllCategorys() throws Exception {
		mvc.perform(get("/show-categorys")).andExpect(status().isOk());
		
//		public void shouldBeOkForAllComics() throws Exception {
//			mvc.perform(get("/show-comics")).andExpect(status().isOk());

	}
	
	@Test
	public void shouldRouteToAllCategorysView() throws Exception {
		mvc.perform(get("/show-categorys")).andExpect(view().name(is("categorys")));
		
//		@Test
//		public void shouldRouteToAllComicsView() throws Exception {
//			mvc.perform(get("/show-comics")).andExpect(view().name(is("comics")));
		
	}
	
	@Test
	public void shouldPutAllCategorysIntoModel() throws Exception {
		Collection<Category> allCategorys = Arrays.asList(category, anotherCategory);
		when(categoryRepo.findAll()).thenReturn(allCategorys);
		
		mvc.perform(get("/show-categorys")).andExpect(model().attribute("categorys", is(allCategorys)));
	}
	
//	public void shouldPutAllComicIntoModel() throws Exception {
//		Collection<Comic> allComics = Arrays.asList(comic, anotherComic);
//		when(comicRepo.findAll()).thenReturn(allComics);
//		
//		mvc.perform(get("/show-comics")).andExpect(model().attribute("comics", is(allComics)));
	

}
