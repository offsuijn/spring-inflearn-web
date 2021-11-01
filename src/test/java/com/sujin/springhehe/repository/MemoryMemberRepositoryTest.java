package com.sujin.springhehe.repository;

import com.sujin.springhehe.domain.Member;
import com.sujin.springhehe.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("haha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hehe");
        repository.save(member2);

        //when
        Member result = repository.findByName("hehe").get();

        //then
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("haha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hehe");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

}
