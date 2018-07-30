package com.wecancodeit.comicreviews.demo;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewComicController {

	@Resource
	ComicRepository comicRepo;

	@Resource
	CategoryRepository categoryRepo;

	@RequestMapping("/comic")
	public String findOneComic(@RequestParam(value = "id") long id, Model model) throws ComicNotFoundException {
		Optional<Comic> comic = comicRepo.findById(id);

		if (comic.isPresent()) {
			model.addAttribute("comic", comic.get());
			return "comic";
		}
		throw new ComicNotFoundException();

	}
	
	@RequestMapping("/add-category")
	public String addCategory( String name) {
		
		Category newCategory = categoryRepo.findByName(name);
		
		Category category = categoryRepo.findByName(name);
		if(category == null) {
			category = new Category(name, name, null);
			categoryRepo.save(category);
		}
		return "redirect:show-comics";
	}
		
	
	@RequestMapping("/add-comic")
	public String addComic(String title, String description, String review, Category category) {
		
//		Category category = categoryRepo.findById(category);
//		if(category == null) {
//			category = new Category(name);
//			categoryRepo.save(category);
//		}
		
		Comic newComic = comicRepo.findByTitle(title);
		
		if (newComic == null) {
			newComic = new Comic(title, description, review,category);
			comicRepo.save(newComic);
		}
		return "redirect:/show-comics";
	}

	@RequestMapping("/show-comics")
	public String findAllComics(Model model) {
		model.addAttribute("comics", comicRepo.findAll());
		return "comics";

	}
	
	@RequestMapping("/delete-comic")
	public String deleteComicByTitle(String title) {
		
		if (comicRepo.findByTitle(title) !=null) {
			Comic deletedComic =comicRepo.findByTitle(title);
			comicRepo.delete(deletedComic);
		}
		return "redirect:show-comics";
	}

	@RequestMapping("/show-category")
	public String findOneCategory(@RequestParam(value = "id") long id, Model model) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepo.findById(id);

		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			model.addAttribute("comics", comicRepo.findByCategory(category.get()));

			return "category";
		}

		throw new CategoryNotFoundException();
	}

	@RequestMapping("/show-categorys")
	public String findAllCategorys(Model model) {
		model.addAttribute("categorys", categoryRepo.findAll());
		return ("categorys");

	}

}
