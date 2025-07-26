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
    public Set<Category> getAllCategoriesBySaloonId(Long id) {
        return categoryRepository.findAllBySaloonId(id);
    }

	@Override
	public Category getCategoryById(Long id) {
		Category category=findCategoryById(id);
		return category;
	}

	@Override
	public void deleteCategoryById(Long categoryId,Long saloonId) {
		Category category=findCategoryById(categoryId);
		if (category.getSaloonId().equals(saloonId)) {
			categoryRepository.deleteById(category.getId());
			
		}
		throw new CategoryBadRequestExeption(String.format(CategoryErrorMessages.NO_PERMIT_FOR_THIS_USER, null));
	}

//------------ CLASS METHODS
	// ------------ find user by id -----------------
	protected Category findCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundExeption(String.format(CategoryErrorMessages.CATEGORY_NOT_FOUND, id)));

		return category;

	}
	

}
