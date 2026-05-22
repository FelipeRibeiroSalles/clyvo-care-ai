package br.com.clyvocareai.dto.alerta;

import java.time.LocalDate;

public record AlertaResponseDTO(

        Long idAlerta,
        String tipoAlerta,
        String mensagem,
        String prioridade,
        LocalDate dataAlerta,
        String status,
        Long idPet,
        String nomePet

) {
}