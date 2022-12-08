package com.example.spearteam.service.dao;

import com.example.spearteam.entity.Member;
import com.example.spearteam.rest.request.MemberRequest;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface MemberDAO {
    List<Member> findAll();
    Member findById(Integer id);

    Member findByEmail(String email);
    void flush();
    void deleteById(Integer id);
    void deleteByEntity(Member member);

    Member findMemberByMemberName (String memberName);

    Member saveMember(MemberRequest member);
    Member updateMember(MemberRequest member, Integer memberId);
}
