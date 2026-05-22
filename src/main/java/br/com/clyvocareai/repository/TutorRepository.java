package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository
        extends JpaRepository<Tutor, Long> {
}