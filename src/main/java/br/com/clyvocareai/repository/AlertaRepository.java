package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository
        extends JpaRepository<Alerta, Long> {
}