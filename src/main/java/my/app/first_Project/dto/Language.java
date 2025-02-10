package my.app.first_Project.dto;

import lombok.Getter;

@Getter
//상수들을 나열해서 사용하는것 Enum
//Enum : 상수(변하지 않는 고정 값)들의 집합
public enum Language {
    JAVA("자바"), C("C언어"), CPP("C++"), PYTHON("파이");
    //실제 키값 (보여질 값)
    private final String description;

    Language(String description) {
        this.description = description;
    }
}
