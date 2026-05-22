package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.HistoricoClinico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoClinicoRepository
        extends JpaRepository<HistoricoClinico, Long> {
}