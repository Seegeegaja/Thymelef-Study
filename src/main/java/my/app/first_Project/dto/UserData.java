package my.app.first_Project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMapping;
@Getter
@Setter
@ToString
public class UserData {
    private String userName;
    private int userAge;
    private String userAddress;

//    public UserData(String userName, int userAge) {
//        this.userName = userName;
//        this.userAge = userAge;
//    }
}
