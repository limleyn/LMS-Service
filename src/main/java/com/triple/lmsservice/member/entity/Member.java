package com.triple.lmsservice.member.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Member {

    @Id
    private String userId;

    private String userName;
    private String passWord;
    private String phoneNumber;

    private LocalDateTime regDt;

}
