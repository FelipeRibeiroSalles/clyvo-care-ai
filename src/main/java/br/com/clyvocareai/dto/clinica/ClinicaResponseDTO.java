package br.com.clyvocareai.dto.clinica;

public record ClinicaResponseDTO(

        Long idClinica,
        String nomeFantasia,
        String cnpj,
        String telefoneClinica,
        String emailClinica,
        String enderecoClinica

) {
}