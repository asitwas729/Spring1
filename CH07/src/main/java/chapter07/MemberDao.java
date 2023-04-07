package chapter07;


import jdk.jfr.Timestamp;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao { //jdbcTemplate 이용

  private JdbcTemplate jdbcTemplate;

  public MemberDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public class MemberRowMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
      Member member = new Member(
          rs.getString("EMAIL"),
          rs.getString("PASSWORD"),
          rs.getString("NAME"),
          rs.getTimestamp("REGDATE").toLocalDateTime()
      );
      member.setId(rs.getLong("ID"));
      return member;
    }
  }

  public Member selectByEmail(String email) {
    List<Member> result = jdbcTemplate.query(
        "select * from MEMBER where EMAIL = ?",
        new MemberRowMapper(), email);
    return result.isEmpty() ? null : result.get(0);
  }

  public List<Member> selectAll() {
    List<Member> result = jdbcTemplate.query(
        "select * from MEMBER", new MemberRowMapper());
    return result;
  }
  public int count() {
    int result = jdbcTemplate.queryForObject(
        "select count(*) from MEMBER", Integer.class);
    return result;
  }
  public void update(Member member) {
    jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL =?",
        member.getName(), member.getPassword(), member.getEmail());
  }
  public void insert(Member member) {
    KeyHolder keyHolder = new KeyHolder() {
    }
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement ps  = con.prepareStatement(
            "insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE)" + "values(?,?,?,?)");
        ps.setString(1, member.getEmail());
        ps.setString(2, member.getPassword());
        ps.setString(3, member.getName());
        ps.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

        return ps;
      }
    }, KeyHolder);
    Number keyValue = keyHolder.getKey();
    member.setId(keyValue.longValue());
  }
}