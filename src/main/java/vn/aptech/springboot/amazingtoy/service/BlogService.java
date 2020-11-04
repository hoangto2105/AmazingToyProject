package vn.aptech.springboot.amazingtoy.service;

import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.dto.model.user.blog.BlogDto;

import java.io.IOException;
import java.util.List;

public interface BlogService {

    List<BlogDto> findAll();
    BlogDto create(BlogDto blogDto) throws IOException;
}
