package com.pragma.home360_microservice_home.home.infrastructure.endpoints.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import com.pragma.home360_microservice_home.home.application.dto.request.SaveCategoryRequest;
import com.pragma.home360_microservice_home.home.application.dto.response.CategoryResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.CustomPageResponse;
import com.pragma.home360_microservice_home.home.application.dto.response.SaveCategoryResponse;
import com.pragma.home360_microservice_home.home.application.services.CategoryService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<SaveCategoryResponse> save(@RequestBody SaveCategoryRequest saveCategoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(saveCategoryRequest));
    }

    @GetMapping("/")
    public ResponseEntity<CustomPageResponse<CategoryResponse>> getAllCategories(@RequestParam(name = "page") Integer page, 
                                                                   @RequestParam(name = "size") Integer size,
                                                                   @RequestParam(name = "orderAsc") boolean orderAsc) {
        return ResponseEntity.ok(categoryService.getCategories(page, size, orderAsc));
    }
}
