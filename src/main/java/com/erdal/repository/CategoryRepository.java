package com.erdal.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
//	 @Query("SELECT c FROM Category c WHERE c.saloonId = :id")
//	    Set<Category> findAllBySaloonId(@Param("id") Long id);
	    Set<Category> findAllBySaloonId( Long id);

}
