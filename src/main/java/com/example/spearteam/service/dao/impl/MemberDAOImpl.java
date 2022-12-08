package com.example.spearteam.service.dao.impl;


import com.example.spearteam.entity.Member;
import com.example.spearteam.rest.request.MemberRequest;
import com.example.spearteam.service.dao.MemberDAO;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class MemberDAOImpl implements MemberDAO {
    @PersistenceContext(unitName = "spearteam")
    EntityManager em;


    @Override
    public List<Member> findAll() {
        Query getAllMember = em.createQuery("SELECT m FROM Member m", Member.class);
        return getAllMember.getResultList();
    }

    @Override
    public Member findById(Integer id) {
        Query getById = em.createQuery("SELECT m FROM Member m WHERE m.memberId = :id", Member.class).setParameter("id", id);
        return (Member) getById.getSingleResult();
    }

    @Override
    public Member findByEmail(String email) {
        Query getByEmail = em.createQuery("SELECT m FROM Member m WHERE m.email = :email",Member.class).setParameter("email",email);
        return (Member) getByEmail.getSingleResult();
    }

    @Override
    public void flush() {
        this.em.flush();
    }

    @Override
    public void deleteById(Integer id) {
        Member member = findById(id);
        if (member != null) {
            this.em.remove(member);
        }
    }

    @Override
    public void deleteByEntity(Member member) {
        this.em.remove(member);
    }

    @Override
    public Member findMemberByMemberName(String memberName) {
        Member member = em.createQuery("SELECT m FROM Member m WHERE m.fullName =:memberName", Member.class).
                setParameter("memberName", memberName).getSingleResult();
        if (member == null) {
            throw new NoResultException("No member found !");
        } else {
            return member;
        }
    }

    @Override
    public Member saveMember(MemberRequest member) {
//        Member checkMem = findByEmail(member.getEmail());
            Member member1 = new Member();
            member1.setEmail(member.getEmail());
            member1.setFullName(member.getFullName());
            member1.setPhone(member.getPhone());
            member1.setUniversity(member.getUniversity());
            member1.setHomeTown(member.getHomeTown());
            member1 = this.em.merge(member1);
            return member1;

    }

    @Override
    public Member updateMember(MemberRequest member, Integer memberId) {
        Member member1 = findById(memberId);

        if(member1!=null){
            member1.setEmail(member.getEmail());
            member1.setFullName(member.getFullName());
            member1.setPhone(member.getPhone());
            member1.setUniversity(member.getUniversity());
            member1.setHomeTown(member.getHomeTown());
            member1 = this.em.merge(member1);
            return member1;
        }else{
            return null;
        }

    }
}
