package com.hello.core.discount;

import com.hello.core.AppConfig;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {


    DiscountPolicy rateDiscountPolicy;

    @BeforeEach
    void forEach(){
        AppConfig appConfig = new AppConfig();
        rateDiscountPolicy = appConfig.discountPolicy();
    }


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member vip = new Member(1L,"vip", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(vip, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC은 할인이 되어서는 안된다.")
    void vip_x(){
        //given
        Member basic = new Member(2L, "basic", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(basic, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }


}