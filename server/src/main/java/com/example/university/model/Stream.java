package com.example.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stream implements Comparable<Stream> {
    @Id
    private String id;
    private String name;
    Set<Course> courses= new HashSet<>();

    @Override
    public int compareTo(Stream o) {
        return this.name.compareTo(o.name);
    }
}
