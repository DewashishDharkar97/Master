package com.bms.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	 @Query(value = "SELECT DISTINCT(location) FROM movie;", nativeQuery=true)
	 List<String> findAllLocations();
	 

}