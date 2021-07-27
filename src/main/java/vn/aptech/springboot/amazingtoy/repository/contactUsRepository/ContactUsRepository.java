package vn.aptech.springboot.amazingtoy.repository.contactUsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.contactus.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
}
