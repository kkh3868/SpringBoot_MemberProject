package com.study.member.repository;

import com.study.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
// Entity, Primary Key의 타입을 매개변수로 받는다
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //  이메일로 회원 정보 조회 (select * from member_table where member_email=?)
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
