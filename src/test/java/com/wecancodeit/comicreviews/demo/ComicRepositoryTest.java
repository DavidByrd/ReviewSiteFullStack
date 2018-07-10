//package com.wecancodeit.comicreviews.demo;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.junit.Assert.assertThat;
//
//import java.util.Collection;
//
//import org.junit.Test;
//
//public class ComicRepositoryTest {
//
//	ComicRepository underTest;
//
//	private long firstComicId = 1L;
//	private Comic firstComic = new Comic();
//	private long secondComicId = 2L;
//	private Comic secondComic = new Comic();
//
//	@Test
//	public void shouldFindAComic() {
//		ComicRepository underTest = new ComicRepository(firstComic);
//		Comic result = underTest.findOne(firstComicId);
//		assertThat(result, is(firstComic));
//
//	}
//
//	@Test
//	public void shouldFindASecondComic() {
//		ComicRepository underTest = new ComicRepository(secondComic);
//		Comic result = underTest.findOne(secondComicId);
//		assertThat(result, is(secondComic));
//
//	}
//
//	@Test
//	public void shouldFindAllComics() {
//		underTest = new ComicRepository(firstComic, secondComic);
//		Collection<Comic> result = underTest.findAll();
//		assertThat(result, containsInAnyOrder(firstComic, secondComic));
//	}
//}
