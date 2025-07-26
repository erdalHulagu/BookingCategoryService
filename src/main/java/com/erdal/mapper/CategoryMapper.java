package com.erdal.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.erdal.model.Category;
import com.erdal.modelDTO.CategoryDTO;

public class CategoryMapper {

	public static CategoryDTO mapToCategoryDTO(Category category) {

		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setCategoryName(category.getCategoryName());
		categoryDTO.setImage(category.getImage());
		categoryDTO.setSaloonId(category.getSaloonId());
		

		return categoryDTO;

	}


	public static Set<CategoryDTO> mapAllListToCategoriesDTO(Set<Category> categories) {
	    return categories.stream()
	        .map(CategoryMapper::mapToCategoryDTO)
	        .collect(Collectors.toSet());
	}

//		
	
	

}
