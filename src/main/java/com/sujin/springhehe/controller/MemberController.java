package com.sujin.springhehe.controller;

import com.sujin.springhehe.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
