package idusw.sb.b202312407.repository;

import idusw.sb.b202312407.domain.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GeneralRepositoryImpl implements GeneralRepository {
    // Repository 구현 ; JDBC 프로그래밍 -> Spring JDBC (JDBCTemplate) -> Spring JPA, Hibernate, MyBatis
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    @Override
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/db_b";
        String user = "root";
        String password = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC Driver를 메모리에 로딩
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            conn =  DriverManager.getConnection(url, user, password); // 로딩된 Driver를 이용하여 연결하고, 객체에 정보를 저장
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<Member>();
        conn = getConnection();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from member");
            while (rs.next()) {
                Member member = Member.builder()
                        .email(rs.getString("email"))
                        .password(rs.getString("password"))
                        .firstName(rs.getString("first_name"))
                        .lastName(rs.getString("last_name"))
                        .build();
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
}