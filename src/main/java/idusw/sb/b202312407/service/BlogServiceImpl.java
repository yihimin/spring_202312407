package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public int create(Blog blog) {
        return 0;
    }

    @Override
    public Blog readById(String id) {
        addFunction();
        return null;
    }
    private void addFunction() {

    }

    @Override
    public List<Blog> readByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Blog> readByEmail(String email) {
        sorting();
        return List.of();
    }
    private void sorting() {

    }

    @Override
    public List<Blog> readByBlogger(String blogger) {
        return List.of();
    }

    @Override
    public List<Blog> readAll() {
        return List.of();
    }

    @Override
    public int update(Blog blog) {
        return 0;
    }

    @Override
    public int delete(Blog blog) {
        return 0;
    }
}
