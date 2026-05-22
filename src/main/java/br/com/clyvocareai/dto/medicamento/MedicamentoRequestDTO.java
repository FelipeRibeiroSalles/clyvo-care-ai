package br.com.clyvocareai.dto.medicamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MedicamentoRequestDTO(

        @NotBlank(message = "Nome do medicamento é obrigatório")
        String nomeMedicamento,

        String dosagem,

        String frequencia,

        @NotNull(message = "Data de início é obrigatória")
        LocalDate dataInicio,

        LocalDate dataFim,

        String observacao,

        @NotNull(message = "Pet é obrigatório")
        Long idPet

) {
}