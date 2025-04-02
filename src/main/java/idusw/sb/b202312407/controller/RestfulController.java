package idusw.sb.b202312407.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {
    @GetMapping("/api")
    public String api() {
        return "using api service"; // 응답을 웹 브라우저에게 반환
    }

}
