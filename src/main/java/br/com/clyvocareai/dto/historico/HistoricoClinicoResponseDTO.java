package br.com.clyvocareai.dto.historico;

import java.time.LocalDate;

public record HistoricoClinicoResponseDTO(

        Long idHistorico,
        String descricaoEvento,
        String categoria,
        LocalDate dataEvento,
        String nivelRisco,
        Long idPet,
        String nomePet

) {
}