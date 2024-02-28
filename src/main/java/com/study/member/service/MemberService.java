package com.study.member.service;

import com.study.member.dto.MemberDTO;
import com.study.member.entity.MemberEntity;
import com.study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        // 1. dto --> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
        // repository의 save 메서드를 호출 (조건, entity 객체를 넘겨줘야 함)
    }
    public MemberDTO login(MemberDTO memberDTO){
        /*
        *  1. 회원이 입력한 이메일로 DB로 조회를 함
        *  2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        * */
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(byMemberEmail.isPresent()){
            // 조회 결과가 있다!
            MemberEntity memberEntity = byMemberEmail.get();
            if(memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())){
                // 비밀번호 일치
                // entity --> dto 변환 후 리턴
                return MemberDTO.toMemberDTO(memberEntity);
            }else{
                // 비밀번호 불일치
                return null;
            }
        }else {
            // 조회 결과가 없다!
            return null;
        }
    }
    public List<MemberDTO> findAll(){
        // 주의! Service 객체 내에서는 항상 Entity가 쓰인다
        // Service 객체 이외의 다른 객체들에서는 DTO가 쓰여야한다
        // Entity 객체의 리스트를 DTO 객체의 리스트로 변환해야함
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity: memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }
}
