package com.study.member.repository;

import com.study.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Entity, Primary Key의 타입을 매개변수로 받는다
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
