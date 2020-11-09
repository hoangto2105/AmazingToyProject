package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.dto.model.user.contactUs.ContactUsDto;
import vn.aptech.springboot.amazingtoy.model.contactus.ContactUs;

import java.util.List;

public interface ContactUsService {
    List<ContactUsDto> findAll();
ContactUsDto create(ContactUsDto contactUsDto);
}
