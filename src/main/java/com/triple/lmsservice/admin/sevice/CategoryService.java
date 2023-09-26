package com.triple.lmsservice.admin.sevice;

import com.triple.lmsservice.admin.dto.CategoryDto;
import com.triple.lmsservice.admin.entity.Category;
import com.triple.lmsservice.admin.model.CategoryInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();
    /**
     * 카테고리 신규 추가
     */
    boolean add(String categoryName);
    /**
     * 카테고리 수정
     */
    boolean update(CategoryInput parameter);
    /**
     * 카테고리 삭제
     */
    boolean del(long id);





}
