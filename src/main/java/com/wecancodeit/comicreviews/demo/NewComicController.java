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
	public String findOneComic(@RequestParam(value="id")long id, Model model) throws ComicNotFoundException {
		Optional<Comic> comic = comicRepo.findById(id);
		
		if(comic.isPresent()) {
			model.addAttribute("comics", comic.get());
			return "comic";
		}
		throw new ComicNotFoundException();
		
		
	}

	@RequestMapping("/show-comics")
	public String findAllComics(Model model) {
		model.addAttribute("comics", comicRepo.findAll());
		return "comics";
		
	}
	
@RequestMapping("/categorys")
	public String findOneCategory(@RequestParam(value = "id")long id, Model model) throws CategoryNotFoundException {
	Optional<Category> category = categoryRepo.findById(id);
	
	if(category.isPresent()) {
		model.addAttribute("categorys", category.get());
		model.addAttribute("comics", comicRepo.findByCategoryContains(category.get()));
	
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
