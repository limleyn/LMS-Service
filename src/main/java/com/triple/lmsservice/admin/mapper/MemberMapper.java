package com.triple.lmsservice.admin.mapper;

import com.triple.lmsservice.admin.dto.MemberDto;
import com.triple.lmsservice.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);

}
