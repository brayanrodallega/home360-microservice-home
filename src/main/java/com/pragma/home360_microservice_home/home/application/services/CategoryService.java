package com.pragma.home360_microservice_home.home.application.services;

import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.application.dto.response.CategoryResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.CustomPageResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.SaveCategoryResponse;

public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
    CustomPageResponse<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc);
}
