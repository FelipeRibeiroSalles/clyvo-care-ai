package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.consulta.ConsultaRequestDTO;
import br.com.clyvocareai.dto.consulta.ConsultaResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Clinica;
import br.com.clyvocareai.model.Consulta;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.model.Veterinario;
import br.com.clyvocareai.repository.ClinicaRepository;
import br.com.clyvocareai.repository.ConsultaRepository;
import br.com.clyvocareai.repository.PetRepository;
import br.com.clyvocareai.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PetRepository petRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final ClinicaRepository clinicaRepository;

    public ConsultaResponseDTO criar(
            ConsultaRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        Veterinario veterinario =
                veterinarioRepository.findById(
                        dto.idVeterinario()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Veterinário não encontrado"
                        ));

        Clinica clinica =
                clinicaRepository.findById(
                        dto.idClinica()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Clínica não encontrada"
                        ));

        Consulta consulta =
                Consulta.builder()
                        .dataConsulta(
                                dto.dataConsulta()
                        )
                        .motivoConsulta(
                                dto.motivoConsulta()
                        )
                        .diagnosticoConsulta(
                                dto.diagnosticoConsulta()
                        )
                        .observacoesConsulta(
                                dto.observacoesConsulta()
                        )
                        .retornoRecomendado(
                                dto.retornoRecomendado()
                        )
                        .pet(pet)
                        .veterinario(veterinario)
                        .clinica(clinica)
                        .build();

        return converterParaDTO(
                consultaRepository.save(consulta)
        );
    }

    public Page<ConsultaResponseDTO> listar(
            Pageable pageable
    ) {

        return consultaRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    public ConsultaResponseDTO buscarPorId(
            Long id
    ) {

        Consulta consulta =
                consultaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Consulta não encontrada"
                                ));

        return converterParaDTO(consulta);
    }

    public void deletar(Long id) {

        Consulta consulta =
                consultaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Consulta não encontrada"
                                ));

        consultaRepository.delete(consulta);
    }

    private ConsultaResponseDTO converterParaDTO(
            Consulta consulta
    ) {

        return new ConsultaResponseDTO(
                consulta.getIdConsulta(),
                consulta.getDataConsulta(),
                consulta.getMotivoConsulta(),
                consulta.getDiagnosticoConsulta(),
                consulta.getObservacoesConsulta(),
                consulta.getRetornoRecomendado(),

                consulta.getPet().getIdPet(),
                consulta.getPet().getNomePet(),

                consulta.getVeterinario()
                        .getIdVeterinario(),

                consulta.getVeterinario()
                        .getNomeVeterinario(),

                consulta.getClinica()
                        .getIdClinica(),

                consulta.getClinica()
                        .getNomeFantasia()
        );
    }
}