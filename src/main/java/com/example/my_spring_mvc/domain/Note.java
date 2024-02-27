package com.example.my_spring_mvc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Note {

    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "UUID")
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

}
