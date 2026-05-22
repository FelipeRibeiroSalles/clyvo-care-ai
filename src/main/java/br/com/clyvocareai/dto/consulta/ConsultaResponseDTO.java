package br.com.clyvocareai.dto.consulta;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(

        Long idConsulta,
        LocalDateTime dataConsulta,
        String motivoConsulta,
        String diagnosticoConsulta,
        String observacoesConsulta,
        LocalDateTime retornoRecomendado,

        Long idPet,
        String nomePet,

        Long idVeterinario,
        String nomeVeterinario,

        Long idClinica,
        String nomeClinica

) {
}