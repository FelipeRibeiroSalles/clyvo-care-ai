package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {
}