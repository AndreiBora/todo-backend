package com.a.a.todo.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Category {
    SHOPPING("Shopping"),
    GYM("Gym"),
    HOBBY("Hobby"),
    FOOD("Food");

    private String value;

    Category(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return this.value;
    }
}
