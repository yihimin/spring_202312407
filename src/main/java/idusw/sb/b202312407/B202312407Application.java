package idusw.sb.b202312407;

import idusw.sb.b202312407.domain.TestLombok;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class B202312407Application {

    public static void main(String[] args) {
        SpringApplication.run(B202312407Application.class, args);

        // 객체의 메소드를 사용하려면, 먼저 클래스로 객체를 생성해야 한다.
        /*
        TestLombok nc = new TestLombok();
        nc.print();
        */
    }

}
