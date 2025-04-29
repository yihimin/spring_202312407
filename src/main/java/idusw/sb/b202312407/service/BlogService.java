package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Blog;

import java.util.List;

public interface BlogService { // 외부 사용법에 대한 규정화
    int create(Blog blog);

    Blog readById(String id); // id-identifier 역할을 하는 식별번호 unique key -> primary key

    List<Blog> readByTitle(String title);
    List<Blog> readByEmail(String email);
    List<Blog> readByBlogger(String blogger);
    List<Blog> readAll();

    int update(Blog blog);
    int delete(Blog blog);
}
