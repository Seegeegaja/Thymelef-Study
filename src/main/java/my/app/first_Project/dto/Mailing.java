package my.app.first_Project.dto;

import lombok.Getter;

@Getter
public enum Mailing {
    NAVER("naver.com"),DAUM("daum.co.kr"),GOOGLE("google.com");
    private final String description;
    Mailing(String description){
        this.description = description;
    }
}
