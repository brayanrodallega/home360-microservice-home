package com.pragma.home360_microservice_home.home.application.services.impl;

import java.time.LocalDateTime;

import com.pragma.home360_microservice_home.commons.configurations.utils.Constants;
import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.application.dto.response.SaveCategoryResponse;
import com.pragma.home360_microservice_home.home.application.mappers.CategoryDtoMapper;
import com.pragma.home360_microservice_home.home.application.services.CategoryService;
import com.pragma.home360_microservice_home.home.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
}
