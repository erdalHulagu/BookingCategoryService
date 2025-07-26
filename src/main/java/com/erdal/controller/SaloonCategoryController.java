package com.erdal.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.mapper.CategoryMapper;
import com.erdal.model.Category;
import com.erdal.modelDTO.CategoryDTO;
import com.erdal.modelDTO.SaloonDTO;
import com.erdal.requests.CategoryRequest;
import com.erdal.responseMessages.CategoryResponse;
import com.erdal.responseMessages.CategoryResponseMessage;
import com.erdal.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories/saloon-owner")
public class SaloonCategoryController {
	
	private final CategoryService categoryService;

	//----------get all category by saloon id-------------
		@PostMapping()
		public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryRequest categoryRequest ) {

			SaloonDTO saloonDTO=new SaloonDTO();
			saloonDTO.setId(1L);
			Category categories=categoryService.saveCategory(categoryRequest,saloonDTO);
			CategoryDTO categoryDTO=CategoryMapper.mapToCategoryDTO(categories);
			return  ResponseEntity.ok(categoryDTO);

		}
		@DeleteMapping
		public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Long id ) {
			
			SaloonDTO saloonDTO=new SaloonDTO();
			saloonDTO.setId(1L);
			categoryService.deleteCategoryById(id,saloonDTO.getId());
			
			CategoryResponse categoryResponse=new CategoryResponse();
			categoryResponse.setMessage(CategoryResponseMessage.CATEGORY_DELETED_MESSAGE);
			return  ResponseEntity.ok(categoryResponse);
			
		}

}
