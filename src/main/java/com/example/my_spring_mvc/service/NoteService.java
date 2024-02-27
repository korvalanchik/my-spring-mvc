package com.example.my_spring_mvc.service;

import com.example.my_spring_mvc.domain.Note;
import com.example.my_spring_mvc.model.NoteDTO;
import com.example.my_spring_mvc.repository.NoteRepository;
import com.example.my_spring_mvc.util.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(final NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDTO> findAll() {
        final List<Note> notes = noteRepository.findAll(Sort.by("id"));
        return notes.stream()
                .map(note -> mapToDTO(note, new NoteDTO()))
                .toList();
    }

    public NoteDTO get(final UUID id) {
        return noteRepository.findById(id)
                .map(note -> mapToDTO(note, new NoteDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public UUID create(final NoteDTO noteDTO) {
        final Note note = new Note();
        mapToEntity(noteDTO, note);
        return noteRepository.save(note).getId();
    }

    public void update(final UUID id, final NoteDTO noteDTO) {
        final Note note = noteRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(noteDTO, note);
        noteRepository.save(note);
    }

    public void delete(final UUID id) {
        noteRepository.deleteById(id);
    }

    private NoteDTO mapToDTO(final Note note, final NoteDTO noteDTO) {
        noteDTO.setId(note.getId());
        noteDTO.setTitle(note.getTitle());
        noteDTO.setContent(note.getContent());
        return noteDTO;
    }

    private Note mapToEntity(final NoteDTO noteDTO, final Note note) {
        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());
        return note;
    }

}
