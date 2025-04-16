package idusw.sb.b202312407.repository;

import idusw.sb.b202312407.domain.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralRepositoryImpl implements GeneralRepository {
    @Override
    public Connection getConnection() {
        try {
            // 예시: JDBC 연결 (데이터소스가 있다면 그걸로 대체)
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_b", "root", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Member member = Member.builder()
                        .email(rs.getString("email"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .password(rs.getString("password"))
                        .build();
                members.add(member);  // 리스트에 추가
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return members;
    }
}
