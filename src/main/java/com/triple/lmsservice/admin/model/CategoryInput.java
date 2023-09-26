package com.triple.lmsservice.admin.model;

import lombok.Data;

@Data
public class CategoryInput {

    long id;
    String categoryName;
    int sortValue;
    boolean usingYn;
}
