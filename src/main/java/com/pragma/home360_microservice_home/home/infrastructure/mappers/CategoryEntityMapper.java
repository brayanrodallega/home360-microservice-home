package com.pragma.home360_microservice_home.home.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;
import com.pragma.home360_microservice_home.home.infrastructure.entities.CategoryEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
    List<CategoryModel> entityListToModelList(List<CategoryEntity> categories);
}
