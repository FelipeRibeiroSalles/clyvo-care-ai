package br.com.clyvocareai.dto.pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetRequestDTO(

        @NotBlank(message = "Nome do pet é obrigatório")
        String nomePet,

        @NotBlank(message = "Espécie é obrigatória")
        String especie,

        String raca,

        @NotBlank(message = "Sexo é obrigatório")
        String sexo,

        String cor,

        Double peso,

        LocalDate dataNascimentoPet,

        String statusSaude,

        @NotNull(message = "Tutor é obrigatório")
        Long idTutor

) {
}