package my.app.first_Project.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private String userName;
    private int userAge;
    private String userAddress;
    private int userWeight;
    private int userHeight;

    public static UserData fromParams(String userName, int userAge, String userAddress, int userWeight, int userHeight) {
        return new UserData(userName, userAge, userAddress, userWeight, userHeight);
    }

//    public UserData(String userName, int userAge) {
//        this.userName = userName;
//        this.userAge = userAge;
//    }
}
