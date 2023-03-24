package config;

import chapter03.ChangePasswordService;
import chapter03.MemberDao;
import chapter03.MemberInfoPrinter;
import chapter03.MemberListPrinter;
import chapter03.MemberPrinter;
import chapter03.MemberRegisterService;
import chapter03.VersionPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf2 {

  @Autowired
  private MemberDao memberDao;

  @Autowired
  private MemberPrinter memberPrinter;


  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService(memberDao);
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    ChangePasswordService changePasswordService = new ChangePasswordService();
    changePasswordService.setMemberDao(memberDao);
    return changePasswordService;
  }

  @Bean
  public MemberListPrinter memberListPrinter() {
    return new MemberListPrinter(memberDao, memberPrinter);
  }

  @Bean
  public MemberInfoPrinter memberInfoPrinter() {
    MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
    memberInfoPrinter.setMemberDao(memberDao);
    memberInfoPrinter.setMemberPrinter(memberPrinter);
    return memberInfoPrinter;
  }

  @Bean
  public VersionPrinter versionPrinter() {
    VersionPrinter versionPrinter = new VersionPrinter();
    versionPrinter.setMajorVersion(2);
    versionPrinter.setMajorVersion(1);
    return versionPrinter;
  }
}