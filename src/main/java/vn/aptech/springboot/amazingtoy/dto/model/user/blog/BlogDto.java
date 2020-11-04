package vn.aptech.springboot.amazingtoy.dto.model.user.blog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.blog.Blog;
import vn.aptech.springboot.amazingtoy.model.user.User;

import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogDto {
    private long id;
    private String title;
    private String description;
    private Timestamp createAt;
    private UserDto userDto;
    private MultipartFile multipartFile;
    private String image;
}
