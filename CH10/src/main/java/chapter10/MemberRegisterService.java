package chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberRegisterService {

  @Autowired
  private MemberDao memberDao;

  // 생성자를 통해 의존 객체를 주입받음
  public MemberRegisterService(MemberDao memberDao) {

  }

  //과제에는 필요없음
  public void regist(RegisterRequest req) {
    // 이메일로 회원 데이터 조회
    Member member = memberDao.selectByEmail(req.getEmail());
    if(member != null) {
      // 이미 같은 이메일 가진 회원이 존재
      throw new DuplicationMemberException("Duplication Email : "+ req.getEmail());
    }

    Member newMem = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
    memberDao.insert(newMem);
  }

}