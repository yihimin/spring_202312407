package idusw.sb.b202312407.domain;

// 롬복 라이브러리에서 Getter/Setter 메서드를 자동 생성해주는 어노테이션을 가져와요.
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;


@Getter
@Setter
@Builder

public class Member {
//    public Member(String email, String firstName, String lastName,String password) {
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//    }
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}