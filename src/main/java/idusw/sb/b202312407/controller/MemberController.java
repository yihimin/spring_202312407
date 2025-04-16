package idusw.sb.b202312407.controller;

import idusw.sb.b202312407.domain.Member;
import idusw.sb.b202312407.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/test")
    public String test(Model model) {
        List<Member> members = memberService.readAll(); // 전체 조회
        model.addAttribute("members", members);
        return "main/tables"; // templates/main/tables.html
    }

    @GetMapping("/login-form")  // @GetMapping 정보 조회, 템플릿 페이지를 접근
    public String loginForm() {
        return "members/login";
    }
    @GetMapping("/login")      // @PostMapping 정보 저장 - body를 통해 정보를 전달함
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        // @Service와 @Repository에게 요청을 전달하여, 처리된 결과를 반환 받음
        System.out.println(email);
        System.out.println(password);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        session.setAttribute("sess", email);
        session.setMaxInactiveInterval(300);
        session.invalidate();
        return "messages/m-login";
    }
    @GetMapping("/register-form")  // @GetMapping 정보 조회, 템플릿 페이지를 접근
    public String registerForm(Model model) {
        //model.addAttribute("memberDto", new Member());
        model.addAttribute("memberDto",
                Member.builder().email("root@induk.ac.kr").build()); // email 필드는 지정된 값으로 빌드

        return "members/register"; // register.html 접근, 기본 suffix는 .html임. suffix 수정 가능
    }
    @PostMapping("/register")      // @PostMapping 정보 저장 - body를 통해 정보를 전달함
    public String register(Member memberDto, Model model) { // @RequestBody
        // @Service와 @Repository에게 요청을 전달하여, 처리된 결과를 반환 받음
        System.out.println(memberDto.getFirstName());
        System.out.println(memberDto.getEmail());
        model.addAttribute("firstName", memberDto.getFirstName());
        return "messages/m-register";   //기본 suffix는 .html임.
    }
    @GetMapping("/forgot-password-form")  // @GetMapping 정보 조회, 템플릿 페이지를 접근
    public String forgotPasswordForm() {
        return "members/forgot-password";
    }
    @GetMapping("/forgot-password")      // @PostMapping 정보 저장 - body를 통해 정보를 전달함
    public String forgotPassword() { //@RequestParam String email, @RequestParam String password) {
        // @Service와 @Repository에게 요청을 전달하여, 처리된 결과를 반환 받음
        return "main/m-forgot-password";
    }
}