package br.com.clyvocareai.dto.veterinario;

public record VeterinarioResponseDTO(

        Long idVeterinario,
        String nomeVeterinario,
        String crmv,
        String especialidade,
        String emailVeterinario,
        String telefoneVeterinario,
        Long idClinica,
        String nomeClinica

) {
}