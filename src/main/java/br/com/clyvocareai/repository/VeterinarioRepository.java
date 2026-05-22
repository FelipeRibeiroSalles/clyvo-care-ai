package br.com.clyvocareai.repository;

import br.com.clyvocareai.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository
        extends JpaRepository<Veterinario, Long> {
}