package config;

import chapter03.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

  @Bean
  public MemberDao memberDao() {
    return new MemberDao();
  }

  @Bean
  public MemberPrinter memberPrinter1() {
    return new MemberPrinter();
  }

  @Bean
  public MemberPrinter memberPrinter2() {
    return new MemberPrinter();
  }

  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService(memberDao());
  }

  @Bean
  @Qualifier("memberPrinter") // 지정해줌
  public ChangePasswordService changePasswordService() {
    ChangePasswordService changePasswordService = new ChangePasswordService();
    // 세터 메서드를 통해 직접 의족을 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입의 빈 객체를 찾아서 주입한다.
    // changePasswordService.setMemberDao(memberDao());
    return changePasswordService;
  }

  @Bean
  public MemberPrinter memberPrinter() {
    return new MemberPrinter();
  }

  @Bean
  public MemberListPrinter memberListPrinter() {
    return new MemberListPrinter(memberDao(), memberPrinter());
  }


}
