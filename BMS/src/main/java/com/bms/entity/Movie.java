package com.bms.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id @GeneratedValue Integer id;
	String location;
	String theatre;
	String movieName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, location, movieName, theatre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return id == other.id && Objects.equals(location, other.location) && Objects.equals(movieName, other.movieName)
				&& Objects.equals(theatre, other.theatre);
	}
	
	@Override
	public String toString() {
		return "Movies [id=" + id + ", location=" + location + ", theatre=" + theatre + ", movieName=" + movieName
				+ "]";
	}
	
}
