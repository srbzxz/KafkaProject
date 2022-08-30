package com.example.kafkaproject.builderses;

public class TestUserClass {

    public static void main(String[] args) {
        User tom = User.builder()
                .name("Tom")
                .age(25)
                .build();
        System.out.println(tom);

//        Person.builder().
    }
}
