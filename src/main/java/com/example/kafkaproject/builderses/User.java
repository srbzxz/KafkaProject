package com.example.kafkaproject.builderses;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString(includeFieldNames = true)
public class User {

    String name;
    int age;
}
