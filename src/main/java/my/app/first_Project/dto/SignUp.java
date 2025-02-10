package my.app.first_Project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUp {
    private String name;
    private String password;
    private String userName;
    private String birth;
    private String sex;
    private String email;
    private String mailing;
    private String phone;
    private String promise;
}
