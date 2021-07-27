package vn.aptech.springboot.amazingtoy.service;

import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.dto.model.user.blog.BlogDto;
import vn.aptech.springboot.amazingtoy.model.blog.Blog;

import java.io.IOException;
import java.util.List;

public interface BlogService {

    List<BlogDto> findAll();
    BlogDto create(BlogDto blogDto) throws IOException;
    Blog update(BlogDto blogDto) throws  IOException;
    BlogDto findById(long id) throws IOException;
    void delete(long id);
}
