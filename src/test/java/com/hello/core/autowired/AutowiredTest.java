package com.hello.core.autowired;

import com.hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(TestBean.class);
        TestBean bean = ac.getBean(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member member1) {
            System.out.println("member = " + member1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member2) {
            System.out.println("member = " + member2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member = " + member3);
        }
    }
}
