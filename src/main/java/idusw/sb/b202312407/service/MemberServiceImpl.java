package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private JdbcTemplate jdbcTemplate;
    public MemberServiceImpl(JdbcTemplate jdbcTemplate) { // 생성자 주입
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(Member member) {
        return 0;
    }

    @Override
    public Member readByEmail(String email) {
        String sql = "SELECT * FROM member WHERE email = ?";
        List<Member> members = jdbcTemplate.query(sql, new Object[]{email}, (resultSet, i) -> {
            return Member.builder()
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .build();
        });

        return members.isEmpty() ? null : members.get(0);
    }

    @Override
    public Member readByEmailPassword(String email, String password) {
        List<Object> params = new ArrayList<>();
        params.add(email);
        params.add(password);

        String sql = "SELECT * FROM member WHERE email=? AND password=?";
        List<Member> members = jdbcTemplate.query(sql, params.toArray(), new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Member.builder()
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .build();
            }
        });

        return members.isEmpty() ? null : members.get(0);
    }

    @Override
    public List<Member> readAll() {
        List<Member> members = jdbcTemplate.query("select * from member", (resultSet, i) -> {
            Member member = Member.builder()
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password")).build();
            return member;
        });
        return members;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(Member member) {
        return 0;
    }
}
