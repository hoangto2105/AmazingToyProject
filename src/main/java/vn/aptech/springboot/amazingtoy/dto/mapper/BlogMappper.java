package vn.aptech.springboot.amazingtoy.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.dto.model.user.blog.BlogDto;
import vn.aptech.springboot.amazingtoy.model.blog.Blog;

@Component
public class BlogMappper {

    public static BlogDto toBlogDto(Blog blog) {
        return new BlogDto()
                .setId(blog.getId())
                .setTitle(blog.getTitle())
                .setImage(blog.getImage())
                .setDescription(blog.getDescription())
                .setCreateAt(blog.getCreateAt());
    }
}
