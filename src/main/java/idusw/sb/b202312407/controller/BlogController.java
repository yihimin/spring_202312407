package idusw.sb.b202312407.controller;

import idusw.sb.b202312407.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @RestController : JSON or XML 형태로 반환
public class BlogController {
    private final BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/blogs")
    public String blogs() {
        blogService.readAll();
        return "main/blogs"; // view로 ./main/blogs.html 템플릿을 사용
    }
}