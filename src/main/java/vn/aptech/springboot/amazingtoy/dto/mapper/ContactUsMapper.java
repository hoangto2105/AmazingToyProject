package vn.aptech.springboot.amazingtoy.dto.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.aptech.springboot.amazingtoy.dto.model.user.contactUs.ContactUsDto;
import vn.aptech.springboot.amazingtoy.model.contactus.ContactUs;

@Component
public class ContactUsMapper {

    public static ContactUsDto toContactUsDto(ContactUs contactUs){
        return new ContactUsDto()
                .setId(contactUs.getId())
                .setName(contactUs.getName())
                .setEmail(contactUs.getEmail())
                .setSubject(contactUs.getSubject())
                .setPhone(contactUs.getPhone())
                 .setMessage(contactUs.getMessage())
                .setCreateAt(contactUs.getCreateAt());
    }
}
