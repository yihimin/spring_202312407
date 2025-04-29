package idusw.sb.b202312407.service;

import idusw.sb.b202312407.domain.Blog;
import java.util.List;

public class SuperBlogServiceImpl implements BlogService {
    @Override
    public int create(Blog blog) {
        return 0;
    }

    @Override
    public Blog readById(String id) {
        return null;
    }

    @Override
    public List<Blog> readByTitle(String title) {
        return List.of();
    }

    @Override
    public List<Blog> readByEmail(String email) {
        return List.of();
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
