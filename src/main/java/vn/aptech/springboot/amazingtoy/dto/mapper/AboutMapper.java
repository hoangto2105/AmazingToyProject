package vn.aptech.springboot.amazingtoy.dto.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.dto.model.user.about.AboutDto;
import vn.aptech.springboot.amazingtoy.model.about.About;

@Component
public class AboutMapper {

    public static AboutDto toAboutDto(About about){
        return new AboutDto()
                .setId(about.getId())
                .setName(about.getName())
                .setDescription(about.getDescription())
                .setCreateAt(about.getCreateAt())
                .setImage(about.getImage());
    }
}
