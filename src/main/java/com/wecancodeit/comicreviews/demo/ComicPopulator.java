package com.wecancodeit.comicreviews.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ComicPopulator implements CommandLineRunner {
	
	@Resource
	private ComicRepository comicRepo;
	
	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private IssueRepository issueRepo;

	@Override
	public void run(String... args) throws Exception {
	
		Category teen = new Category("Teen", "Ages 13 and up");
		teen = categoryRepo.save(teen);
		Category allAges = new Category("All Ages", "If you can read, hop in!");
		allAges = categoryRepo.save(allAges);
		Category mature = new Category("Mature", "Sorry kiddies, 18 and up only");
		mature = categoryRepo.save(mature);
		
		Comic invincible = new Comic("Invincible", "The story of Mark Grayson, the son of the worlds most powerful hero, Omni-man", "Thumbs Up! This is my favorite series by Image Comics", teen);
		teen = categoryRepo.save(teen);
		Comic spiderman = new Comic("SpiderMan", "The heroics of Peter Parker, bitten by a radioactive spider and became your friendly neighborhood Spiderman", "Thumbs Up! My love for SpiderMan trnscends time and space!", allAges);
		allAges = categoryRepo.save(allAges);
		Comic saga = new Comic("Saga", "A family caught in the middle of an intergalactic war", "Thumbs Up! Take Romeo & Juliet, social commentary, Star Wars, and adult drama, put it all in a blender and you have Saga!", mature);
		mature = categoryRepo.save(mature);
		
		issueRepo.save(new Issue("Issue One", saga));
		issueRepo.save(new Issue("Issue One", invincible));
		issueRepo.save(new Issue("Issue One", spiderman));


		
	}

}
