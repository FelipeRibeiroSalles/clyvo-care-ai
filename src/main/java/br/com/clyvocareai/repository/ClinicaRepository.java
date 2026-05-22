package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository
        extends JpaRepository<Clinica, Long> {
}