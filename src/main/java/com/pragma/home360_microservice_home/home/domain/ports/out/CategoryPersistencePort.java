package com.pragma.home360_microservice_home.home.domain.ports.out;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;
import org.springframework.data.domain.Page;


public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
