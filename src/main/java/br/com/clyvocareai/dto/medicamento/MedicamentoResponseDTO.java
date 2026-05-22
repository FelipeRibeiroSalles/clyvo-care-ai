package br.com.clyvocareai.dto.medicamento;

import java.time.LocalDate;

public record MedicamentoResponseDTO(

        Long idMedicamento,
        String nomeMedicamento,
        String dosagem,
        String frequencia,
        LocalDate dataInicio,
        LocalDate dataFim,
        String observacao,
        Long idPet,
        String nomePet

) {
}