package my.app.first_Project.dto;

import lombok.Getter;

@Getter
public enum Promise {
    CHECK1("전체약관 동의합니다"),CHECK2("이용약관 동의"),CHECK3("개인정보 수집-이용동의(필수)"),CHECK4("개인정보 수집-이용 동의(선택)");
    private final String description;
    Promise(String description){
        this.description = description;

    }
}
