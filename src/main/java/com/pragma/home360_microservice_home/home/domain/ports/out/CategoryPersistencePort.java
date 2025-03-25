package com.pragma.home360_microservice_home.home.domain.ports.out;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;

public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
}
