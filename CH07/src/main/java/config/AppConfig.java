package config;

import chapter07.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration //Spring 설정 파일로 지정
@ComponentScan(basePackages = {"db","chapter07"})
public class AppConfig {

  @Bean
  public PlatformTransactionManager transactionManager(){
    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource());
    return dataSourceTransactionManager;
  }

  //DB Connection을 위한 Bean
  @Bean(destroyMethod = "close")
  public DataSource dataSource() { //tomcat으로 import
    DataSource ds = new DataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/daelim?characterEncoding=utf8");
    ds.setUsername("root");
    ds.setPassword("1234");
    ds.setInitialSize(2);
    ds.setMaxActive(10);
    ds.setMaxIdle(10);
    ds.setTestWhileIdle(true); // 유휴 커넥션 검사
    ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기로 유휴 커넥션이 유효한지 검사
    ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴시간 3분
    return ds;
  }

  @Bean
  public MemberDao memberDao() {
    return new MemberDao(dataSource());
  }

  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService();
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    return new ChangePasswordService();
  }

  @Bean
  @Qualifier("memberPrinter")
  //Autowired는 자동으로 객체를 등록해서 주입. 주입해야하는 객체 파일이 2개 이상 있으면 에러 발생
  public MemberPrinter membernPrinter() {
    return new MemberPrinter();
  }

  @Bean
  public MemberPrinter membernPrinter2() {
    return new MemberPrinter();
  }

  @Bean
  public MemberListPrinter memberListPrinter() {
    return new MemberListPrinter();
  }

  @Bean
  public MemberInfoPrinter memberInfoPrinter() { //setter 메서드를 통해 의존 주입
    return new MemberInfoPrinter();
  }

  @Bean
  public VersionPrinter versionPrinter() {
    VersionPrinter versionPrinter = new VersionPrinter();
    versionPrinter.setMajorVersion(5); //기본타입 값도 이런 형식으로 주입 가능
    versionPrinter.setMinorVersion(3);
    return versionPrinter;
  }
}