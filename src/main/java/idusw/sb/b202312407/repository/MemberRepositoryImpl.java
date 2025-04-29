package idusw.sb.b202312407.repository;

import idusw.sb.b202312407.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Framework가 DI(Dependency Inject)가 필요함을 표현함
 * @ComponentScan 을 통해 클래스로 부터 객체를 생성하여 등록함
 * @Component, @Service, @Repository, @Controller, @Configuration
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository {
    /**
     * 생성자가 없는 경우 디폴트 생성자를 컴파일러가 추가함. 객체 생성시 호출함
     * MemberRepository memberRepository = new MemberRepositoryImpl(); 하지 않아도 됨
     * boiler-plate code 구현
     */
    @Override
    public void create(MemberEntity member) {

    }

    @Override
    public MemberEntity findById(int id) {
        return null;
    }

    @Override
    public List<MemberEntity> getMembers() {
        return List.of();
    }

    @Override
    public void update(MemberEntity member) {

    }

    @Override
    public void delete(MemberEntity member) {

    }
}
