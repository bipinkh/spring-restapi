package com.bipinkh.springrestapi.controllers;

import com.bipinkh.springrestapi.models.Note;
import com.bipinkh.springrestapi.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
//The @Controller annotation is used to define a controller
// The @ResponseBody annotation is used to indicate that the return value of a method should be used as the response body of the request.
@RestController
@RequestMapping("/noteapi")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/ping")
    public String pingServer() {
        return "access notes using api endpoints";
    }

    // Get All Notes
    @GetMapping("/notes") //short form of @RequestMapping(value="/notes", method=RequestMethod.Post)
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        //If the request body doesn’t have a title or a content, then spring will return a 400 BadRequest error to the client
        return noteRepository.save(note);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long noteId) {
        //The @PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter
        //ResponseEntity class gives us more flexibility while returning a response from the api.
        //For example, in the above api, If a note doesn’t exist with the given id,
        // then we’re returning a 404 Not Found error with the help of ResponseEntity
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return ResponseEntity.ok(updatedNote);
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}