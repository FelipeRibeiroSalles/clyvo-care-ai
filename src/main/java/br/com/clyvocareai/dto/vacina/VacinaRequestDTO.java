package br.com.clyvocareai.dto.vacina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VacinaRequestDTO(

        @NotBlank(message = "Nome da vacina é obrigatório")
        String nomeVacina,

        String fabricante,

        String dose,

        @NotNull(message = "Data de aplicação é obrigatória")
        LocalDate dataAplicacao,

        LocalDate proximaDose,

        @NotBlank(message = "Status é obrigatório")
        String status,

        @NotNull(message = "Pet é obrigatório")
        Long idPet

) {
}