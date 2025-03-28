package com.pragma.home360_microservice_home.home.application.services.impl;

import java.time.LocalDateTime;

import com.pragma.home360_microservice_home.commons.configurations.utils.Constants;
import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.application.dto.response.CategoryResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.CustomPageResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.SaveCategoryResponse;
import com.pragma.home360_microservice_home.home.application.mappers.CategoryDtoMapper;
import com.pragma.home360_microservice_home.home.application.services.CategoryService;
import com.pragma.home360_microservice_home.home.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public CustomPageResponse<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        var categoryModels = categoryServicePort.getCategories(page, size, orderAsc);
        var categoryResponses = categoryDtoMapper.modelListToResponseList(categoryModels.getContent());
        return new CustomPageResponse<>(
            categoryResponses,
            categoryModels.getNumber(),
            categoryModels.getSize(),
            categoryModels.getTotalElements(),
            categoryModels.getTotalPages()
        );
    }
}
