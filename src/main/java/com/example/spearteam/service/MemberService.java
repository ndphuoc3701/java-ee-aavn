package com.example.spearteam.service;

import com.example.spearteam.rest.request.MemberRequest;
import com.example.spearteam.service.dao.MemberDAO;
import com.example.spearteam.service.dto.MemberDTO;
import com.example.spearteam.service.mapper.MemberMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class MemberService {

    @Inject
    private MemberDAO memberDAO;

    @Inject
    private MemberMapper memberMapper;

    public List<MemberDTO> getAll() {
        return memberMapper.toDtos(memberDAO.findAll());
    }

    public MemberDTO getById(Integer id) {
        return memberMapper.toDto(memberDAO.findById(id));
    }

    public MemberDTO createMember(MemberRequest member) {
        return memberMapper.toDto(memberDAO.saveMember(member));
    }


    public MemberDTO updateMember(MemberRequest member, Integer id) {
        return memberMapper.toDto(memberDAO.updateMember(member, id));
    }

    public void deleteMemberById(Integer id) {
        memberDAO.deleteById(id);
    }


}
