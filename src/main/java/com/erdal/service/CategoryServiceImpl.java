package com.erdal.service;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.erdal.exeptions.CategoryBadRequestExeption;
import com.erdal.exeptions.CategoryErrorMessages;
import com.erdal.exeptions.CategoryNotFoundExeption;
import com.erdal.model.Category;
import com.erdal.modelDTO.SaloonDTO;
import com.erdal.repository.CategoryRepository;
import com.erdal.requests.CategoryRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	
	private final CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(CategoryRequest categoryRequest, SaloonDTO saloonDTO) {
		 
		Category category=new Category();
		category.setCategoryName(categoryRequest.getCategoryName());
		category.setImage(categoryRequest.getImage());
		category.setSaloonId(saloonDTO.getId());
		
		Category ctd= categoryRepository.save(category);
		return ctd;
	}

	@Override
	public Set<Category> getallCategoriesBySaloonId(Long id) {
		Set<Category> categories=categoryRepository.findAllBySaloonId(id);
		return categories;
	}

	@Override
	public Category getCategoryById(Long id) {
		Category category=findCategoryById(id);
		return category;
	}

	@Override
	public void deleteCategoryById(Long categoryId,Long saloonId) {
		Category category=findCategoryById(categoryId);
		if (category.getSaloonId()!=(saloonId)) {
			
			throw new CategoryBadRequestExeption(CategoryErrorMessages.NO_PERMIT_FOR_THIS_USER);
		}
		categoryRepository.deleteById(categoryId);
	}

//------------ CLASS METHODS
	// ------------ find user by id -----------------
	protected Category findCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundExeption(String.format(CategoryErrorMessages.CATEGORY_NOT_FOUND, id)));

		return category;

	}
	

}
