package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private JdbcTemplate jdbcTemplate;
    public MemberServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Member> getMembers() {
        List<Member> members = jdbcTemplate.query("select * from bmember",(resultSet, i) -> {
            Member member = Member.builder().firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password")).build();
            return member;
        });
        return members;
    }
}
