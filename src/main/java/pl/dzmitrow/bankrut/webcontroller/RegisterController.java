package pl.dzmitrow.bankrut.webcontroller;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dzmitrow.bankrut.model.api.RegisterUserDTO;

@Slf4j
@Controller
public class RegisterController {

    public RegisterUserDTO registerUserDTO;

    @RequestMapping(path = "/register/submit")
    public String register(RegisterUserDTO registerUserDTO){
        log.info("registering {}", registerUserDTO);
        return "redirect:/login?registered";
    }

}
