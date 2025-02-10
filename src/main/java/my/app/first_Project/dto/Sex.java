package my.app.first_Project.dto;

import lombok.Getter;

@Getter
public enum Sex {
    Male("남자"),feMale("여자"), none("없음");
    private final String description;
    Sex(String description) {
        this.description = description;
    }
}
