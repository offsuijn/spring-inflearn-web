package com.sujin.springhehe;

import com.sujin.springhehe.repository.JdbcMemberRepository;
import com.sujin.springhehe.repository.MemberRepository;
import com.sujin.springhehe.repository.MemoryMemberRepository;
import com.sujin.springhehe.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
