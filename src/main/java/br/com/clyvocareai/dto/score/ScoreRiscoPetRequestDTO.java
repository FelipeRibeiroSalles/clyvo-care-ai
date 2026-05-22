package br.com.clyvocareai.dto.score;

import jakarta.validation.constraints.NotNull;

public record ScoreRiscoPetRequestDTO(

        @NotNull(message = "Score é obrigatório")
        Double scoreRisco,

        @NotNull(message = "Pet é obrigatório")
        Long idPet

) {
}