package idusw.sb.b202312407.controller;

import idusw.sb.b202312407.domain.Member;
import idusw.sb.b202312407.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    /**
     * DI(Dependency Injection) : 의존성 주입, 의존관계에 있는 객체를 필요시점에 사용할 수 있도록 프레이워크가 제어함
     * MemberController 객체는 MemeberService 객체를 사용하여 처리한다.
     * 따라서 MemberController 객체가 생성되기 전 MemberService 객체가 생성되어 있어야 함.
     * 이를 Spring Framework (DI Container)가 처리함
     * 1. Constructor Injection( 생성자 주입), 2. Setter Injection(세터 주입), 3. Field Injectioin(필드 주입)
     */
    //@Autowired
    private MemberService memberService;
    public MemberController(MemberService memberService) { // Constructor Injection
        this.memberService = memberService;
    }
    @GetMapping("/test")
    public String test(Model model) {
        /*
        Member member = memberService.readByEmail("egyou@induk.ac.kr");
        System.out.println(member.getEmail() + " : "
                + member.getFirstName() + ": " + member.getLastName());
        */
        List<Member> members = memberService.readAll();
        for (Member member : members) {
            System.out.println(member.getEmail() + " : "
                    + member.getFirstName() + ": " + member.getLastName());
        }
        model.addAttribute("members", members);

        return "main/tables";
    }
    @GetMapping("/login")
    //@RequestMapping(value="/login", method={RequestMethod.GET})
    public String login(@RequestParam String email, @RequestParam String password,
                        Model model, HttpSession session, HttpServletRequest request) {
        Member member = memberService.readByEmailPassword(email, password);
        // HttpSession sess = request.getSession();
        if(member != null) {
            /*
            model.addAttribute("name", member.getEmail().substring(0,email.indexOf('@')) + "님 환영합니다."); // ${name}
            egyou@induk.ac.kr : @의 index를 indexOf -> 5, substring(0, 5) : 0, ~ 4의 부분 문자열을 반환
            session.setMaxInactiveInterval(30*60); // 30분간 유효
             */
            session.setAttribute("name", member.getEmail().substring(0,email.indexOf('@')) + "님 환영합니다."); // ${session.name}
        }
        else {
            session.setAttribute("name", "Check Your Email or Password!");
        }
        return "messages/m-login"; // template에게 email, password : model
    }
    @GetMapping("/login-form") // URL , a href="<reference>", http://localhost:8080/login-form
    // @RequestMapping(value="/login-form", method = {RequestMethod.GET} )
    public String loginForm() {
        return "members/login";    // view에게 전달하여 응답을 처리함, main/login -> main/login.html
        // "/" == http://localhost:8080/ == static == templates == Application Context
    }
    @PostMapping("/register") // action="./register" or "/register" , method="post"경우 @PostMapping
    public String register(Member memberDto,
                           Model model) {
        // @Service, @Repository 를 활용한 업무 및 데이터 처리 요청 및 결과
        System.out.println(memberDto.getFirstName());
        model.addAttribute("firstName", memberDto.getFirstName());
        return "messages/m-register"; // firstName 속성 값을 전달해주어 m-register.html에서 사용
    }
    @GetMapping("/register-form") // URL , a href="<reference>", http://localhost:8080/login-form
    // @RequestMapping(value="/login-form", method = {RequestMethod.GET} )
    public String registerForm(Model model) { // 등록폼에 model객체를 활용하여 속성(객체, 문자열 등)을 전달
        // model.addAttribute("memberDto", new Member());
        model.addAttribute("memberDto",
                Member.builder()
                        .email("root@induk.ac.kr")
                        .firstName("root").build());
        return "members/register";  // suffix는 .html로 기본 설정되어 있음.
        // application.properties 활용하여 변경 가능함

    }
    @GetMapping("/forgot-password-form")
    public String forgotPasswordForm(Model model) {
        return "members/forgot-password";
    }
    @PostMapping("/forgot-password")
    public String forgotPassword() {

        return "messages/m-forgot-password";
    }
}
