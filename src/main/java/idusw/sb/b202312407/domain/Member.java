package idusw.sb.b202312407.domain;

// 롬복 라이브러리에서 Getter/Setter 메서드를 자동 생성해주는 어노테이션을 가져와요.
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;


@Getter
@Setter
@Builder    // Builder 패턴을 사용한 객체 생성 (초기화)
public class Member { // Beans 규약에 맞는 클래스를 선언하고 생성한 객체 : Bean 객체
    // 복합어 표현 : DB는 (_) 을 선호, Web (-) 선호, Java는 Camel 표기법(단어시작을 대문자)을 선호
    // private Long seq;    // 유일키, primary key
    /*
    public Member(String email, String password) {
        this.email = email;
    };
    public Member(String email, String firstName, String lastName, String password) {
        this.email = email;
    };
     */
    private String firstName; // DB 테이블의 특정 필드와 매칭, first_name
    private String lastName; // DB 테이블의 특정 필드와 매칭, first_name
    private String email;
    private String password;
}
