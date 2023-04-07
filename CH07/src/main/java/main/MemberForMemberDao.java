package main;

import chapter07.Member;
import chapter07.MemberDao;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberForMemberDao {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
//    Member member = memberDao.selectByEmail("a@a.com");
//    System.out.println(member.getId() + ", "+ member.getEmail()+", "+member.getName());

    selectAll();
    update();
    insert();
    selectAll();
  }
  public static void selectAll(){
    int count = memberDao.count();

  }

  public static void update(){
    Member member = MemberDao.selectByEmail("a@a.com"); //MemberDao -> memberDao
    String oldPassword = member.getPassword();
    String newPassword = Double.toHexString(Math.random());
    member.changePassword(oldPassword, newPassword);
    MemberDao.update(member); //newPassword가 들어갔음  //MemberDao -> memberDao
    System.out.println("ChangePassword : " + oldPassword + " -> " + newPassword);
  }

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");

  public static void insert(){
    String prefix = formatter.format(LocalDateTime.now());
    Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
    memberDao.insert(member);
    System.out.println("Insert Member >>> " + member.getName() + ", " + member.getId());
  }
}
