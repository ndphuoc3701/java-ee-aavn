package com.spearteam;

import com.example.spearteam.entity.Member;
import com.example.spearteam.rest.request.MemberRequest;
import com.example.spearteam.service.MemberService;
import com.example.spearteam.service.dao.MemberDAO;
import com.example.spearteam.service.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {


    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberDAO memberDAO;

    @Mock
    private MemberMapper memberMapper;

    @Test
    void test() {

//        MemberRequest request = new MemberRequest(1,"Nguyen Hong Phuc",
//                "phuc@gmail.com", "0362481438", "Vung Tau", "UTE");
//        Member m = memberDAO.saveMember(request);
//
//        List<Member> listMembers = memberDAO.findAll();
//        if (m == null) {
//            System.out.println("Fail");
//        } else {
//            System.out.println(m.getFullName());
//        }


    }

}
