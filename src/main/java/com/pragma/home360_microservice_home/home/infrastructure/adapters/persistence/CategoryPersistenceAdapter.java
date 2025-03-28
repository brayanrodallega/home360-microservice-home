package com.pragma.home360_microservice_home.home.infrastructure.adapters.persistence;

import com.pragma.home360_microservice_home.home.domain.model.CategoryModel;
import com.pragma.home360_microservice_home.home.domain.ports.out.CategoryPersistencePort;
import com.pragma.home360_microservice_home.home.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.home360_microservice_home.home.infrastructure.repositories.mysql.CategoryRepository;
import com.pragma.home360_microservice_home.commons.configurations.utils.Constants;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;


@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }

    @Override
    public Page<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination = orderAsc
            ? PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending())
            : PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return categoryRepository.findAll(pagination).map(categoryEntityMapper::entityToModel);
    }
}
