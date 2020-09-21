package pl.dzmitrow.bankrut.webcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dzmitrow.bankrut.model.api.RegisterUserDTO;

@Slf4j
@Controller
public class RegisterController {

    private UserDetailsService userDetailsService;

    public RegisterController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(path = "/register/submit")
    public String register(RegisterUserDTO registerUserDTO){
        log.info("registering {}", registerUserDTO);

        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(registerUserDTO.getLogin())
                        .password(registerUserDTO.getPassword())
                        .roles("USER")
                        .build();
        ((InMemoryUserDetailsManager) userDetailsService).createUser(user);
        return "redirect:/login?registered";
    }

}
