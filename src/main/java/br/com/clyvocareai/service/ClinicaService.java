package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.clinica.ClinicaRequestDTO;
import br.com.clyvocareai.dto.clinica.ClinicaResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Clinica;
import br.com.clyvocareai.repository.ClinicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicaService {

    private final ClinicaRepository clinicaRepository;

    public ClinicaResponseDTO criar(
            ClinicaRequestDTO dto
    ) {

        Clinica clinica =
                Clinica.builder()
                        .nomeFantasia(dto.nomeFantasia())
                        .cnpj(dto.cnpj())
                        .telefoneClinica(dto.telefoneClinica())
                        .emailClinica(dto.emailClinica())
                        .enderecoClinica(dto.enderecoClinica())
                        .build();

        return converterParaDTO(
                clinicaRepository.save(clinica)
        );
    }

    public Page<ClinicaResponseDTO> listar(
            Pageable pageable
    ) {

        return clinicaRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    public ClinicaResponseDTO buscarPorId(
            Long id
    ) {

        Clinica clinica =
                clinicaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Clínica não encontrada"
                                ));

        return converterParaDTO(clinica);
    }

    public ClinicaResponseDTO atualizar(
            Long id,
            ClinicaRequestDTO dto
    ) {

        Clinica clinica =
                clinicaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Clínica não encontrada"
                                ));

        clinica.setNomeFantasia(
                dto.nomeFantasia()
        );

        clinica.setCnpj(
                dto.cnpj()
        );

        clinica.setTelefoneClinica(
                dto.telefoneClinica()
        );

        clinica.setEmailClinica(
                dto.emailClinica()
        );

        clinica.setEnderecoClinica(
                dto.enderecoClinica()
        );

        return converterParaDTO(
                clinicaRepository.save(clinica)
        );
    }

    public void deletar(Long id) {

        Clinica clinica =
                clinicaRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Clínica não encontrada"
                                ));

        clinicaRepository.delete(clinica);
    }

    private ClinicaResponseDTO converterParaDTO(
            Clinica clinica
    ) {

        return new ClinicaResponseDTO(
                clinica.getIdClinica(),
                clinica.getNomeFantasia(),
                clinica.getCnpj(),
                clinica.getTelefoneClinica(),
                clinica.getEmailClinica(),
                clinica.getEnderecoClinica()
        );
    }
}