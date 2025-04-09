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
    @GetMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        List<Member> members = memberService.getMembers();
        for (Member member : members) {
            System.out.println(member.getEmail() + " " + member.getFirstName() + " " + member.getLastName());
        }
        /*
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
*/
        return "messages/m-login";
    }
    @GetMapping("/login-form") // URL , a href="<reference>", http://localhost:8080/login-form
    // @RequestMapping(value="/login-form", method = {RequestMethod.GET} )
    public String loginForm() {
        return "members/login";    // view에게 전달하여 응답을 처리함, main/login -> main/login.html
        // "/" == http://localhost:8080/ == static == templates == Application Context
    }
    @PostMapping("/register") //action="/register"일 때, method="post"면 @PostMapping
    public String register(Member memberDto,
                           Model model) {
        System.out.println(memberDto.getFirstName());
        model.addAttribute("firstName", memberDto.getFirstName());
        return "messages/m-register";
    }
    @GetMapping("/register-form")
    public String registerForm(Model model) {
        //model.addAttribute("memberDto", new Member());
         model.addAttribute("memberDto",
                 Member.builder()
                 .email("root@induk.ac.kr").firstName("root").build());
        return "members/register";
    }
}
