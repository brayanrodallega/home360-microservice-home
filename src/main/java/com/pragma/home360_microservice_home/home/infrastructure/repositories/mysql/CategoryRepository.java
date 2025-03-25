package com.pragma.home360_microservice_home.home.infrastructure.repositories.mysql;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pragma.home360_microservice_home.home.infrastructure.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
