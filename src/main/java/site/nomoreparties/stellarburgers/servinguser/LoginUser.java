package site.nomoreparties.stellarburgers.servinguser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUser {
    private String email;
    private String password;
}

