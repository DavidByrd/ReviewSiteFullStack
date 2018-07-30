package com.wecancodeit.comicreviews.demo;


import java.util.ArrayList;
import static java.lang.String.format;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tags {
	
	@Id
	@GeneratedValue
	private long id;

//	private long comicId;
	private String title;
	private String description;
	private String review;
	
	@JsonIgnore
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	@ManyToOne
	private Comic comic;
	
	@JsonIgnore
	@OneToMany(mappedBy = "comic")
	private Collection<Issue>issues;

	private String name;
	
	public Collection<String> getCategoriesURLs() {
		Collection<String> urls = new ArrayList<>();
		for(Category t: tags) {
			urls.add(format("/tags/%id/category/%s", this.getId(), t.getName()));
		}
		return urls;
	}

	public void Comic() {
		
	}
	
	public Tags(String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comic other = (Comic) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Long getId() {

		return id;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public String getReview() {
		
		return review;
	}

	public Collection<Issue> getIssues() {
		// TODO Auto-generated method stub
		return issues;
	}
	
	public Collection<Category> getCategorys() {
		return category;
	}
	

}


}
