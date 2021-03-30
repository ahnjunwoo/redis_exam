package com.codegun.redis.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }
}
