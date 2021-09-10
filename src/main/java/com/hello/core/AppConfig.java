package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
        // return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }
}
