package com.a.a.todo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {
    private String id;
    private String title;
    private String description;
    @Getter(AccessLevel.NONE)
    private Category category;
    private Date date;

    public String getCategory(){
        return category.getValue();
    }
}
