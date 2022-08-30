package com.example.kafkaproject.builderses;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {

    String name;
    int age;
    boolean isActive;
    String role;

    @Builder
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
