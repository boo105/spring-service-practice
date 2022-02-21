package webservice.springservicepractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webservice.springservicepractice.repository.MemberRepository;
import webservice.springservicepractice.repository.MemoryMemberRepository;
import webservice.springservicepractice.service.MemberService;

@Configuration
public class SpringConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService((MemoryMemberRepository) memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
