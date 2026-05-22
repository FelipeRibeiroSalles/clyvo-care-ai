package br.com.clyvocareai.dto.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(

        @NotNull(message = "Data da consulta é obrigatória")
        LocalDateTime dataConsulta,

        @NotBlank(message = "Motivo da consulta é obrigatório")
        String motivoConsulta,

        String diagnosticoConsulta,

        String observacoesConsulta,

        LocalDateTime retornoRecomendado,

        @NotNull(message = "Pet é obrigatório")
        Long idPet,

        @NotNull(message = "Veterinário é obrigatório")
        Long idVeterinario,

        @NotNull(message = "Clínica é obrigatória")
        Long idClinica

) {
}