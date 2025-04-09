package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    List<Member> getMembers();
}
