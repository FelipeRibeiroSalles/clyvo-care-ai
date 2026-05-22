package br.com.clyvocareai.dto.veterinario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeterinarioRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nomeVeterinario,

        @NotBlank(message = "CRMV é obrigatório")
        String crmv,

        String especialidade,

        String emailVeterinario,

        String telefoneVeterinario,

        @NotNull(message = "Clínica é obrigatória")
        Long idClinica

) {
}