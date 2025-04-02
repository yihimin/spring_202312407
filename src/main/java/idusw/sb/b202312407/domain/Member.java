package idusw.sb.b202312407.domain;

// 롬복 라이브러리에서 Getter/Setter 메서드를 자동 생성해주는 어노테이션을 가져와요.
import lombok.Getter;
import lombok.Setter;

// 아래 어노테이션 2개 덕분에, 직접 get/set 메서드를 작성하지 않아도 자동으로 만들어져요!
@Getter // → getEmail(), getPassword(), getFirstName() 자동 생성
@Setter // → setEmail(), setPassword(), setFirstName() 자동 생성
public class Member {

    // 사용자 이메일 주소를 저장할 변수예요.
    private String email;

    // 사용자 비밀번호를 저장할 변수예요. (※ 보안상 실제 저장할 땐 암호화 필요!)
    private String password;

    // 사용자 이름 중 '이름' 부분을 저장할 변수예요. 예: "희민"
    // DB에서는 보통 first_name 으로 되어 있는 컬럼과 매핑될 수 있어요.
    private String firstName;
}