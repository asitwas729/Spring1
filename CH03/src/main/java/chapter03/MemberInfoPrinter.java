package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

public class MemberInfoPrinter {
  // 메서드명: printMemberInfo, 매개변수: 이메일
  // 동작1. 이메일로 등록된 멤버인지 검증, 등록되지 않으면 데이터 없다고 출력
  // 동작2. 멤버가 존재하면 memberPrinter.print(member)

  private MemberDao memberDao;
  private MemberPrinter memberPrinter;

  @Bean
  public

  @Bean
  public void MemberPrinter(MemberPrinter memberPrinter) {
    this.memberPrinter = memberPrinter;
  }

  private static void printMemberInfo(String email) {
    Member member = memberdao.selectByID
        if(email == null){
          // 이메일로 등록되지 않은 멤버
          throw new DuplicationMemberException("No Data");
        }

  }
}
