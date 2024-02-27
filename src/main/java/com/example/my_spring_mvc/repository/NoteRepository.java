package com.example.my_spring_mvc.repository;

import com.example.my_spring_mvc.domain.Note;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoteRepository extends JpaRepository<Note, UUID> {
}
