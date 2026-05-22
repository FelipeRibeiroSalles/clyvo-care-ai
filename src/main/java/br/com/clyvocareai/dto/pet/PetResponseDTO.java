package br.com.clyvocareai.dto.pet;

import java.time.LocalDate;

public record PetResponseDTO(

        Long idPet,
        String nomePet,
        String especie,
        String raca,
        String sexo,
        String cor,
        Double peso,
        LocalDate dataNascimentoPet,
        String statusSaude,
        Long idTutor,
        String nomeTutor

) {
}