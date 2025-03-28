package com.pragma.home360_microservice_home.home.domain.usecases;

import com.pragma.home360_microservice_home.home.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;
import com.pragma.home360_microservice_home.home.domain.ports.in.CategoryServicePort;
import com.pragma.home360_microservice_home.home.domain.ports.out.CategoryPersistencePort;

import org.springframework.data.domain.Page;

public class CategoryUseCase implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void save(CategoryModel categoryModel) {
        CategoryModel category = categoryPersistencePort.getCategoryByName(categoryModel.getName());
        if (category != null) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.save(categoryModel);
    }

    @Override
    public Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryPersistencePort.getCategories(page, size, orderAsc);
    }
}
