package com.pragma.home360_microservice_home.home.domain.ports.in;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;
import org.springframework.data.domain.Page;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
    Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
