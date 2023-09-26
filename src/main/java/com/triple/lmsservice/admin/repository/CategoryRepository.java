package com.triple.lmsservice.admin.repository;

import com.triple.lmsservice.admin.entity.Category;
import com.triple.lmsservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
