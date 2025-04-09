package idusw.sb.b202312407.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Spring 프로젝트를 개발할 때 컨트롤러를 지정함
public class HomeController {
    @GetMapping("/forgot-password-form")
    public String forgotForm() {
        return "members/forgot-password";
    }


    @GetMapping("/404")
    public String go404() {
        return "main/404"; // view resolving
    }
    @GetMapping("/")
    // URL - http://localhost:8080/
    // http://localhost:8080, http://localhost:8080/default-page (index.html, index.jsp ... )
    public String index() {
        return "main/index";
    }

}
