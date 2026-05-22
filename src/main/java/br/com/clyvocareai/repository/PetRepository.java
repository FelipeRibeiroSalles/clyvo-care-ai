package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository
        extends JpaRepository<Pet, Long> {

    List<Pet> findByTutorIdTutor(
            Long idTutor
    );

    Page<Pet> findByNomePetContainingIgnoreCase(
            String nomePet,
            Pageable pageable
    );
}