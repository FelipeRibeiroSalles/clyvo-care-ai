package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.veterinario.VeterinarioRequestDTO;
import br.com.clyvocareai.dto.veterinario.VeterinarioResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Clinica;
import br.com.clyvocareai.model.Veterinario;
import br.com.clyvocareai.repository.ClinicaRepository;
import br.com.clyvocareai.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;
    private final ClinicaRepository clinicaRepository;

    public VeterinarioResponseDTO criar(
            VeterinarioRequestDTO dto
    ) {

        Clinica clinica =
                clinicaRepository.findById(
                        dto.idClinica()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Clínica não encontrada"
                        ));

        Veterinario veterinario =
                Veterinario.builder()
                        .nomeVeterinario(
                                dto.nomeVeterinario()
                        )
                        .crmv(dto.crmv())
                        .especialidade(
                                dto.especialidade()
                        )
                        .emailVeterinario(
                                dto.emailVeterinario()
                        )
                        .telefoneVeterinario(
                                dto.telefoneVeterinario()
                        )
                        .clinica(clinica)
                        .build();

        return converterParaDTO(
                veterinarioRepository.save(
                        veterinario
                )
        );
    }

    public Page<VeterinarioResponseDTO> listar(
            Pageable pageable
    ) {

        return veterinarioRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    public VeterinarioResponseDTO buscarPorId(
            Long id
    ) {

        Veterinario veterinario =
                veterinarioRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Veterinário não encontrado"
                                ));

        return converterParaDTO(veterinario);
    }

    private VeterinarioResponseDTO converterParaDTO(
            Veterinario veterinario
    ) {

        return new VeterinarioResponseDTO(
                veterinario.getIdVeterinario(),
                veterinario.getNomeVeterinario(),
                veterinario.getCrmv(),
                veterinario.getEspecialidade(),
                veterinario.getEmailVeterinario(),
                veterinario.getTelefoneVeterinario(),
                veterinario.getClinica()
                        .getIdClinica(),
                veterinario.getClinica()
                        .getNomeFantasia()
        );
    }
}