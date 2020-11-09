package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.aptech.springboot.amazingtoy.controller.v1.command.UserRegisterFormCommand;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {

        String referrer = httpServletRequest.getHeader("Referer");
        httpServletRequest.getSession().setAttribute("return_url_login", referrer);

        return "frontend/layout/pages/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("userRegisterFormCommand", new UserRegisterFormCommand());

        return "frontend/layout/pages/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid UserRegisterFormCommand userRegisterFormCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "frontend/layout/pages/register";
        } else {
            try {
                UserDto newUser = registerUser(userRegisterFormCommand);
                return "redirect:/user/dashboard";
            } catch (Exception exception) {
                bindingResult.rejectValue("email", "error.userRegisterFormCommand", exception.getMessage());
                return "frontend/layout/pages/register";
            }
        }
    }

    private UserDto registerUser(UserRegisterFormCommand userRegisterFormCommand) throws IOException {

        UserDto userDto = new UserDto()
                .setEmail(userRegisterFormCommand.getEmail())
                .setPassword(userRegisterFormCommand.getPassword())
                .setFirstName(userRegisterFormCommand.getFirstName())
                .setLastName(userRegisterFormCommand.getLastName())
                .setPhoneNumber(userRegisterFormCommand.getPhoneNumber());

        UserDto user = userService.register(userDto);

        return user;
    }
}
