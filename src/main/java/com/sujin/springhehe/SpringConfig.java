package com.sujin.springhehe;

import com.sujin.springhehe.repository.MemberRepository;
import com.sujin.springhehe.repository.MemoryMemberRepository;
import com.sujin.springhehe.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
