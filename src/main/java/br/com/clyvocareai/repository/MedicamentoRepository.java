package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository
        extends JpaRepository<Medicamento, Long> {
}