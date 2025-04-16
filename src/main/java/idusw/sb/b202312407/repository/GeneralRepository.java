package idusw.sb.b202312407.repository;

import idusw.sb.b202312407.domain.Member;

import java.sql.Connection;
import java.util.List;

public interface GeneralRepository {
    Connection getConnection();
    List<Member> findAll();  // 메서드 선언 올바르게 마무리!
}
