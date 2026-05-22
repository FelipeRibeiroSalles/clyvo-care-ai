package br.com.clyvocareai.dto.score;

import java.time.LocalDate;

public record ScoreRiscoPetResponseDTO(

        Long idScore,
        Double scoreRisco,
        String classificacao,
        LocalDate dataCalculo,
        Long idPet,
        String nomePet

) {
}