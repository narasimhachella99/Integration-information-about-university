package com.example.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String address;
}
