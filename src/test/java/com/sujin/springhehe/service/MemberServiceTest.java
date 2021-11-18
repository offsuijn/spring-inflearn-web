package com.sujin.springhehe.service;

import com.sujin.springhehe.domain.Member;
import com.sujin.springhehe.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    // 정상 플로우
    @Test
    public void 회원가입() {

        //Given
        Member member1 = new Member();
        member1.setName("spring");

        //When
        Long savedId = memberService.join(member1);

        //Then
        Member findMember = memberRepository.findById(savedId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());

    }

    // 예외 플로우
    @Test
    public void 중복_회원_예외() {

        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->
                memberService.join(member2));

        //Then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
