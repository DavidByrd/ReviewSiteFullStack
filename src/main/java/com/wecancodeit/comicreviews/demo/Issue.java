package com.wecancodeit.comicreviews.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Issue {
	
	@Id
	@GeneratedValue
	private long id;

	private String number;
	
	@ManyToOne
	private Comic comic;
	
	public Issue() {
		
	}

	public Issue(String number, Comic comic) {
		this.number = number;
		this.comic = comic;
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
		Issue other = (Issue) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
