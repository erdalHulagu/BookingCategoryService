package com.erdal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	    Set<Category> findAllBySaloonId( Long saloonId);

}
