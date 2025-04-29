package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Member;

import java.util.List;

public interface MemberService {
    // C.R.U.D - Boiler Plate Code (반복적인 코드, 상용적으로 활용되는 코드)
    int create(Member member);
    Member readByEmail(String email);
    Member readByEmailPassword(String email, String password);
    List<Member> readAll();
    int update(Member member);
    int delete(Member member);
}

