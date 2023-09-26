package com.triple.lmsservice.admin.sevice.impl;

import com.triple.lmsservice.admin.dto.CategoryDto;
import com.triple.lmsservice.admin.entity.Category;
import com.triple.lmsservice.admin.repository.CategoryRepository;
import com.triple.lmsservice.admin.sevice.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> list() {

        List<Category> categories = categoryRepository.findAll();
        return CategoryDto.of(categories);
    }

    @Override
    public boolean add(String categoryName) {

        //카테고리명이 중복인거 체크

        Category category = Category.builder()
                .categoryName(categoryName)
                .usingYn(true)
                .sortValue(0)
                .build();
        categoryRepository.save(category);

        return true;
    }

    @Override
    public boolean update(CategoryDto parameter) {
        return false;
    }

    @Override
    public boolean del(long id) {
        return false;
    }
}
