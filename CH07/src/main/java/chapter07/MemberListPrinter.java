package chapter07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("memberListPrinter")
public class MemberListPrinter {

  @Autowired
  private MemberDao memberDao;
  @Autowired
  private MemberPrinter memberPrinter;

//    public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
//        this.memberDao = memberDao;
//        this.memberPrinter = memberPrinter;
//    }
  public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
    this.memberDao = memberDao;
    this.memberPrinter = memberPrinter;
  }

  public void printAll() {
    // 현재까지 등록된 전체 멤버리스트
    Collection<Member> members = memberDao.selectAll();
    members.forEach(m -> memberPrinter.print(m));
  }

}