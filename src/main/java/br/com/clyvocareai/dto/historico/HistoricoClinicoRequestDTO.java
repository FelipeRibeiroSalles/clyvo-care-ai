package br.com.clyvocareai.dto.historico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record HistoricoClinicoRequestDTO(

        @NotBlank(message = "Descrição é obrigatória")
        String descricaoEvento,

        @NotBlank(message = "Categoria é obrigatória")
        String categoria,

        @NotNull(message = "Data do evento é obrigatória")
        LocalDate dataEvento,

        String nivelRisco,

        @NotNull(message = "Pet é obrigatório")
        Long idPet

) {
}