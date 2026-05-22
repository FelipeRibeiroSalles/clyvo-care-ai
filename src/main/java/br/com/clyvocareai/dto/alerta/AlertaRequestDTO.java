package br.com.clyvocareai.dto.alerta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertaRequestDTO(

        @NotBlank(message = "Tipo do alerta é obrigatório")
        String tipoAlerta,

        @NotBlank(message = "Mensagem é obrigatória")
        String mensagem,

        @NotBlank(message = "Prioridade é obrigatória")
        String prioridade,

        @NotBlank(message = "Status é obrigatório")
        String status,

        @NotNull(message = "Pet é obrigatório")
        Long idPet

) {
}