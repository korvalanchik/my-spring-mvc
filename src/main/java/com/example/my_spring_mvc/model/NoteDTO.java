package com.example.my_spring_mvc.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteDTO {

    private UUID id;

    @NotNull
    @Size(max = 255)
    private String title;

    @Size(max = 500)
    private String content;

}
