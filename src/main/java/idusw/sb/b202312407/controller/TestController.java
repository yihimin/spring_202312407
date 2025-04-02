package idusw.sb.b202312407.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Spring 프로젝트를 개발할 때 컨트롤러를 지정함
public class TestController {
    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        String pw = "cometrue";
        if(pw.equals(password)) {
            System.out.println(email);
            System.out.println(password);
            model.addAttribute("email", email);
            model.addAttribute("name", email.substring(0,email.indexOf('@'))+"님");
            session.setAttribute("name", email.substring(email.indexOf('@')+1));
        }
        else {
            System.out.println("Wrong password");
        }

        return "messages/m-login";
    }
    @GetMapping("/login-form") // URL , a href="<reference>", http://localhost:8080/login-form
    // @RequestMapping(value="/login-form", method = {RequestMethod.GET} )
    public String loginForm() {
        return "members/login";    // view에게 전달하여 응답을 처리함, main/login -> main/login.html
        // "/" == http://localhost:8080/ == static == templates == Application Context
    }
    @PostMapping("/register") //action="/register"일 때, method="post"면 @PostMapping
    public String register(@RequestParam("first-name") String fname,
                           @RequestParam("last-name") String lname,
                           @RequestParam String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("firstName", fname);
        model.addAttribute("lastName", lname);
        return "messages/m-register";
    }
    @GetMapping("/register-form")
    public String registerForm() {
        return "members/register";
    }
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
