package com.bipinkh.springrestapi.repositories;

import com.bipinkh.springrestapi.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{
}

//     JpaRepository interface defines methods for all the CRUD operations on the entity,
//        and a default implementation of JpaRepository called SimpleJpaRepository.
// now be able to use JpaRepository’s methods like save(), findOne(), findAll(), count(), delete() etc.