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
public class Scholarship {
    @Id
    private String id;
    private String university;
    private String eligibility;
    private String amount;
    private String rank;
}
