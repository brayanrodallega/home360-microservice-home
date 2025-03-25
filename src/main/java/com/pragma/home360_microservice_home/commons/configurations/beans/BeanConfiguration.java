package com.pragma.home360_microservice_home.commons.configurations.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.home360_microservice_home.home.domain.ports.in.CategoryServicePort;
import com.pragma.home360_microservice_home.home.domain.ports.out.CategoryPersistencePort;
import com.pragma.home360_microservice_home.home.domain.usecases.CategoryUseCase;
import com.pragma.home360_microservice_home.home.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.pragma.home360_microservice_home.home.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.home360_microservice_home.home.infrastructure.repositories.mysql.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
}
