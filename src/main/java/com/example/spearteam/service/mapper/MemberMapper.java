package com.example.spearteam.service.mapper;


import com.example.spearteam.entity.Member;
import com.example.spearteam.service.dto.MemberDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface MemberMapper{


MemberDTO toDto(Member member);
List<MemberDTO> toDtos(List<Member> memberList);

Member toEntity(MemberDTO memberDTO);
List<Member> toListEntities(List<MemberDTO> memberDTOList);
}
