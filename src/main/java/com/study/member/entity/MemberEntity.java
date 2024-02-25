package com.study.member.entity;

import com.study.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// DB를 생성해주는 클래스다
@Entity
@Setter
@Getter
@Table(name = "member_table") // DB에 실제 테이블을 생성하는데 필요한 이름
public class MemberEntity {
    @Id // Primary Key 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) //  unique 제약조건 추가
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;
    
    // DTO를 Entity로 바꿔주는 static 메서드
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());

        return memberEntity;
    }
}
