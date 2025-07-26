package com.erdal.controller;

import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.mapper.CategoryMapper;
import com.erdal.model.Category;
import com.erdal.modelDTO.CategoryDTO;
import com.erdal.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {
	
	
	private final CategoryService categoryService;
	
	
	
	
	
	
//----------get all category by saloon id-------------
	 @GetMapping("/saloon/{id}")
	    public ResponseEntity<Set<CategoryDTO>> getCategoriesBySaloonId(@PathVariable Long id) {
	        Set<Category> categories = categoryService.getallCategoriesBySaloonId(id);
	     
	        Set<CategoryDTO> categoryDTOs = CategoryMapper.mapAllListToCategoriesDTO(categories);

	        return ResponseEntity.ok(categoryDTOs);
	    }


	
	//----------get category by id-----------
	@GetMapping("{id}")
	public ResponseEntity<CategoryDTO>  getCategoryById(@PathVariable Long id) {
		
		Category category=categoryService.getCategoryById(id);
		
		CategoryDTO categoryDTO=CategoryMapper.mapToCategoryDTO(category);
		
		 
		 return ResponseEntity.ok(categoryDTO);
		 
	}
	
	
	

}
