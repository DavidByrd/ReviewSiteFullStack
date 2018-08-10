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
public class Comic {
	
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
	@OneToMany(mappedBy = "comic")
	private Collection<Issue>issues;
	
	
	

	public Comic() {
		
	}
	
	public Comic(String title, String description, String review, Category category) {
//		this.comicId = comicId;
		this.title = title;
		this.description = description;
		this.review = review;
		this.category = category;
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
	
	public Category getCategory() {
		return category;
		
	}
	
	
	}
	


