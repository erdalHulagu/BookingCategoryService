package com.erdal.service;

import java.util.Set;

import com.erdal.model.Category;
import com.erdal.modelDTO.SaloonDTO;
import com.erdal.requests.CategoryRequest;

public interface CategoryService {

	Category saveCategory(CategoryRequest categoryRequest, SaloonDTO saloonDTO);

	Set<Category> getallCategoriesBySaloonId(Long id);

	Category getCategoryById(Long id);
	
	void deleteCategoryById(Long category,Long saloonId);

}
