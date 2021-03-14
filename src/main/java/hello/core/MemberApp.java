package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        순수 자바 코드를 이용 (구현체까지 의존하고있는 상황)
//        MemberService memberService = new MemberServiceImpl();

//        순수 자바 코드를 이용 (AppConfig를 통해 인터페이스만 의존. DIP를 지키고있다.)
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        스프링 컨테이너 이용
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
