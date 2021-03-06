package com.wecancodeit.comicreviews.demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.assertj.core.util.Arrays;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String description;
	
	@OneToMany(mappedBy= "category")
	private Collection<Comic> comics;
	

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category() {

	}

	public Category(String name, String description, Comic...comics) {
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Collection<Comic> getComics() {
	
		return comics;
	}
	
	

}
