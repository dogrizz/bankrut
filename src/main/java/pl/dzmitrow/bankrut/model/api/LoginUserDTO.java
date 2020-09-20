package pl.dzmitrow.bankrut.model.api;

import lombok.Value;

@Value
public class LoginUserDTO {
    String user;
    String password;
}
