package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.ScoreRiscoPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRiscoPetRepository
        extends JpaRepository<ScoreRiscoPet, Long> {
}