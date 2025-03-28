package com.pragma.home360_microservice_home.home.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.application.dto.response.CategoryResponse;
import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryDtoMapper {
    CategoryModel requestToModel(SaveCategoryRequest saveCategoryRequest);
    CategoryResponse modelToResponse(CategoryModel categoryModel);
    List<CategoryResponse> modelListToResponseList(List<CategoryModel> categories);
}
