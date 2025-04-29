package idusw.sb.b202312407.repository;

import idusw.sb.b202312407.entity.MemberEntity;
import java.util.List;

public interface MemberRepository {
    // insert
    void create(MemberEntity member);
    // select
    MemberEntity findById(int id);
    List<MemberEntity> getMembers();
    // update
    void update(MemberEntity member);
    // delete
    void delete(MemberEntity member);
}