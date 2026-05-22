package br.com.clyvocareai.dto.clinica;

import jakarta.validation.constraints.NotBlank;

public record ClinicaRequestDTO(

        @NotBlank(message = "Nome fantasia é obrigatório")
        String nomeFantasia,

        @NotBlank(message = "CNPJ é obrigatório")
        String cnpj,

        String telefoneClinica,

        String emailClinica,

        @NotBlank(message = "Endereço é obrigatório")
        String enderecoClinica

) {
}