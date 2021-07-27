package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.dto.mapper.ContactUsMapper;
import vn.aptech.springboot.amazingtoy.dto.model.user.contactUs.ContactUsDto;
import vn.aptech.springboot.amazingtoy.model.contactus.ContactUs;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.repository.contactUsRepository.ContactUsRepository;
import vn.aptech.springboot.amazingtoy.repository.user.UserRepository;
import vn.aptech.springboot.amazingtoy.service.ContactUsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsServiceImpl implements ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ContactUsDto> findAll() {
        List<ContactUsDto> result = new ArrayList<>();
        List<ContactUs> contactUses = contactUsRepository.findAll();
        for (ContactUs contactUs : contactUses) {
            ContactUsDto contactUsDto = new ContactUsDto();
            contactUsDto.setId(contactUs.getId());
            contactUsDto.setCreateAt(contactUs.getCreateAt());
            contactUsDto.setEmail(contactUs.getEmail());
            contactUsDto.setMessage(contactUs.getMessage());
            contactUsDto.setName(contactUs.getName());
            contactUsDto.setPhone(contactUs.getPhone());
            contactUsDto.setMessage(contactUs.getMessage());
            contactUsDto.setSubject(contactUs.getSubject());
            result.add(contactUsDto);
        }
        return result;
    }

    @Override
    public ContactUsDto create(ContactUsDto contactUsDto) {
        ContactUs contactUs = new ContactUs();

        contactUs.setName(contactUsDto.getName());
        contactUs.setEmail(contactUsDto.getEmail());
        contactUs.setPhone(contactUsDto.getPhone());
        contactUs.setSubject(contactUsDto.getSubject());
        contactUs.setMessage(contactUsDto.getMessage());
        return ContactUsMapper.toContactUsDto(contactUsRepository.save(contactUs));
    }

    @Override
    public Optional<ContactUs> findById(long id) {
        return contactUsRepository.findById(id);
    }
}

