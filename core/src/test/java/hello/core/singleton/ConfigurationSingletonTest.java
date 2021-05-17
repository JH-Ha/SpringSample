package hello.core.singleton;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.AppConfig;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberSerive = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderSerive = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository =  ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberSerive.getMemberRepository();
        MemberRepository memberRepository2 = orderSerive.getMemberRepository();

        System.out.println(memberRepository1);
        System.out.println(memberRepository2);
        System.out.println(memberRepository);

        Assertions.assertThat(memberSerive.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderSerive.getMemberRepository()).isSameAs(memberRepository);
    }
}
