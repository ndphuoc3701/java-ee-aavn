package com.example.spearteam.service.mapper;

import com.example.spearteam.entity.Member;
import com.example.spearteam.service.dto.MemberDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-08T09:12:53+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.17 (Eclipse Adoptium)"
)
@ApplicationScoped
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setFullName( member.getFullName() );
        memberDTO.setEmail( member.getEmail() );
        memberDTO.setPhone( member.getPhone() );
        memberDTO.setHomeTown( member.getHomeTown() );
        memberDTO.setUniversity( member.getUniversity() );

        return memberDTO;
    }

    @Override
    public List<MemberDTO> toDtos(List<Member> memberList) {
        if ( memberList == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( memberList.size() );
        for ( Member member : memberList ) {
            list.add( toDto( member ) );
        }

        return list;
    }

    @Override
    public Member toEntity(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member member = new Member();

        member.setFullName( memberDTO.getFullName() );
        member.setEmail( memberDTO.getEmail() );
        member.setPhone( memberDTO.getPhone() );
        member.setHomeTown( memberDTO.getHomeTown() );
        member.setUniversity( memberDTO.getUniversity() );

        return member;
    }

    @Override
    public List<Member> toListEntities(List<MemberDTO> memberDTOList) {
        if ( memberDTOList == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>( memberDTOList.size() );
        for ( MemberDTO memberDTO : memberDTOList ) {
            list.add( toEntity( memberDTO ) );
        }

        return list;
    }
}
