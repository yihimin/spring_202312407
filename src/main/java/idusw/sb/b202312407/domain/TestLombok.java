package idusw.sb.b202312407.domain;

import lombok.Getter;
import lombok.Setter;

@Getter // lombok annotation
@Setter
public class TestLombok {
    // MVC에서 Model = DTO + DAO, MVC에서 C(Controller)는 MVCS의 Controller와 Service(business logic)로 나누어짐
    // DTO (Data Transfer Object): 요청 정보를 서비스에 보내거나, 서비스로 부터 처리결과를 가져올 때 사용
    // DAO (Data Access Object) : DTO(domain 객체)와 entity 객체를 활용하여 Data Source(DB, files)와 연동하여 데이터처리를 수행하는 객체
    // Beans 규약 : POJO(Plain Old Java Object)
    // 기본에 충실한, 최소한의 정의를 같는 클래스 선언 방법
    private String message;
    private boolean flag;
    public TestLombok() {

    }
/*
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
*/

    public void print() {
        System.out.println("메시지를 출력합니다.");
    }
}
