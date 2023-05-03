package config;

import chapter10.ChangePasswordService;
import chapter10.MemberDao;
import chapter10.MemberRegisterService;
import chapter11.AuthService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

  @Bean(destroyMethod = "close")
  public DataSource dataSource() {
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
  public PlatformTransactionManager transactionManager() {
    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource());
    return dataSourceTransactionManager;
  }

  @Bean
  public MemberDao memberDao() {
    return new MemberDao(dataSource());
  }

  @Bean
  public MemberRegisterService memberRegisterService() {
    return new MemberRegisterService(memberDao());      //임의로 memberDao() 입력
  }

  @Bean
  public ChangePasswordService changePasswordService() {
    return new ChangePasswordService();
  }


  @Bean
  public AuthService authService() {
    return new AuthService();
  }
}