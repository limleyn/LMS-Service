package com.triple.lmsservice.admin.sevice.impl;

import com.triple.lmsservice.admin.dto.CategoryDto;
import com.triple.lmsservice.admin.entity.Category;
import com.triple.lmsservice.admin.mapper.CategoryMapper;
import com.triple.lmsservice.admin.model.CategoryInput;
import com.triple.lmsservice.admin.repository.CategoryRepository;
import com.triple.lmsservice.admin.sevice.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }

    @Override
    public List<CategoryDto> list() {
        List<Category> categories = categoryRepository.findAll(getSortBySortValueDesc());
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
    public boolean update(CategoryInput parameter) {

        Optional<Category> optionalCategory = categoryRepository.findById(parameter.getId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(parameter.getCategoryName());
            category.setSortValue(parameter.getSortValue());
            category.setUsingYn(parameter.isUsingYn());
            categoryRepository.save(category);
        }

        return true;
    }

    @Override
    public boolean del(long id) {

        categoryRepository.deleteById(id);

        return true;
    }


    @Override
    public List<CategoryDto> frontList(CategoryDto parameter) {

        return categoryMapper.select(parameter);
    }
}