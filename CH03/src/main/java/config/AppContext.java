package config;

import chapter03.ChangePasswordService;
import chapter03.MemberDao;
import chapter03.MemberListPrinter;
import chapter03.MemberPrinter;
import chapter03.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

  @Bean
  public MemberDao memberDao() {
    return new MemberDao();
  }

  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService(memberDao());
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    ChangePasswordService changePasswordService = new ChangePasswordService();
    changePasswordService.setMemberDao(memberDao());
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
