package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository
        extends JpaRepository<Vacina, Long> {
}