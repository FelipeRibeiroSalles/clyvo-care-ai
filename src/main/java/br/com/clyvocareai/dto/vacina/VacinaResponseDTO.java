package br.com.clyvocareai.dto.vacina;

import java.time.LocalDate;

public record VacinaResponseDTO(

        Long idVacina,
        String nomeVacina,
        String fabricante,
        String dose,
        LocalDate dataAplicacao,
        LocalDate proximaDose,
        String status,
        Long idPet,
        String nomePet

) {
}