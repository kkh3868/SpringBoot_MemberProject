package com.study.member.dto;

// lombok 라이브러리는 annotation만으로도 클래스의 Getter Setter등을 정의해줌
import com.study.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 정의
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 정의
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        return memberDTO;
    }
}
