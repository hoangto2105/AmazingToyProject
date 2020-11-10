package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.dto.model.user.about.AboutDto;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.model.about.About;

import java.io.IOException;
import java.util.List;

public interface AboutService {
    List<AboutDto> findAll();
    AboutDto findById(long id);
    AboutDto create(AboutDto aboutDto) throws IOException;
    About update(AboutDto aboutDto) throws  IOException;
    void delete(long id);

}
