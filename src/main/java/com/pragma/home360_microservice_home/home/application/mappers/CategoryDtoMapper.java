package com.pragma.home360_microservice_home.home.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
}
