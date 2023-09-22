package com.triple.lmsservice.member.repository;

import com.triple.lmsservice.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmailAuthKey(String emailAuthKey);
    Optional<Member> findByUserIdAndUserName(String userId, String userName);

    Optional<Member> findByResetPasswordKey(String resetPasswordKey);

}
