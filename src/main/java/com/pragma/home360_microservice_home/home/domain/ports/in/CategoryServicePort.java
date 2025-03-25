package com.pragma.home360_microservice_home.home.domain.ports.in;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;

public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
}
