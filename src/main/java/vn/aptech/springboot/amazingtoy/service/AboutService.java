package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.dto.model.user.about.AboutDto;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface AboutService {
    List<AboutDto> findAll();
    AboutDto create(AboutDto aboutDto) throws IOException;
}
