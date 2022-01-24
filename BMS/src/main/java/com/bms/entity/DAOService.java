package com.bms.entity;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DAOService {
	
	@Autowired
	private MovieRepository mRepo;
	
	 public List<Movie> listAll() {
	        return mRepo.findAll();
	 }
	 
	 public Movie save(Movie movie) {
	        return mRepo.save(movie);
	 }
	 
	 public List<String> findAllLocations(){
		 
		 return mRepo.findAllLocations();
	 }
}
