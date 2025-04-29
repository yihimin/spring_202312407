package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Member;
import idusw.sb.b202312407.entity.MemberEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    // JDBCTemplate은 데이터 소스와 직접 처리하는 클래스로 spring jdbc에서 제공, Repository와 유사함
    private JdbcTemplate jdbcTemplate;
    // 생성자 주입 : DataSource 객체는 application.properties or application.yaml 로 부터 정보를 가져옴
    public MemberServiceImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /* 다음주
    private MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    */
    @Override
    public int create(Member member) {
        return 0;
    }

    @Override
    public Member readByEmail(String email) {
        Member member = null;
        List<Member> members = jdbcTemplate.query("select * from member where email=?", new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Member m = Member.builder()
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password")).build();
                return m;
            }
        }, email);
        return members.isEmpty() ? null : members.get(0);
    }

    @Override
    public Member readByEmailPassword(String email, String password) {
        /*
        List<Object> params = new ArrayList<Object>();
        params.add(email);
        params.add(password);
         */
        List<Member> members = jdbcTemplate.query("select * from member where email=? and password=?",
                new RowMapper<Member>() { // 익명 클래스 - 익명(anonymous) 객체, 변수에 배정하면 지속적으로 사용하거나 상태 변화를 유지
                    @Override
                    public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        Member m = Member.builder()
                                .firstName(resultSet.getString("first_name"))
                                .lastName(resultSet.getString("last_name"))
                                .email(resultSet.getString("email"))
                                .password(resultSet.getString("password")).build();
                        return m;
                    }
                }, email, password);
        /*
        RowMapper rowMapper = new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
        };
        rowMapper.mapRow()

         */
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
