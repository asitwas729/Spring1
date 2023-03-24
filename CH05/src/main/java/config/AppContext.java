package config;

import chapter03.MemberDao;
import chapter03.MemberPrinter;
import chapter03.MemberSummaryPrinter;
import chapter03.VersionPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"chapter03"}
    //,excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern = "chapter03\\..*Dao")
    // 3-1 정규표현식(chapter03의 dao로 끝나는 파일 제외)
    //,excludeFilters = @ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "chapter03.*Dao")
    // 3-2 AspectJ
    //,excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class)
    // 3-3 ASSIGNABLE_TYPE
    //,excludeFilters = {
    //@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class),
    //@ComponentScan.Filter(type= FilterType.REGEX, pattern = "chapter03\\..*Dao")
    //}
    // 3-4 excludeFilters속성(설정할 필터가 2개 이상이면 배열 사용)
)
public class AppContext {

  @Bean
  @Qualifier("memberPrinter")
  public MemberPrinter memberPrinter1() {
    return new MemberPrinter();
  }

  @Bean
  @Qualifier("summaryPrinter")
  public MemberSummaryPrinter memberPrinter2() {
    return new MemberSummaryPrinter();
  }

  @Bean
  public VersionPrinter versionPrinter() {
    VersionPrinter versionPrinter = new VersionPrinter();
    versionPrinter.setMajorVersion(2);
    versionPrinter.setMajorVersion(1);
    return versionPrinter;
  }
}