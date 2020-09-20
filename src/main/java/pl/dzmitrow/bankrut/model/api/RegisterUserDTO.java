package pl.dzmitrow.bankrut.model.api;

import lombok.Value;

@Value
public class RegisterUserDTO {
    String login;
    String password;
    String displayName;
}
