package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.alerta.AlertaRequestDTO;
import br.com.clyvocareai.dto.alerta.AlertaResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Alerta;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.repository.AlertaRepository;
import br.com.clyvocareai.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository alertaRepository;
    private final PetRepository petRepository;

    public AlertaResponseDTO criar(
            AlertaRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        Alerta alerta =
                Alerta.builder()
                        .tipoAlerta(
                                dto.tipoAlerta()
                        )
                        .mensagem(
                                dto.mensagem()
                        )
                        .prioridade(
                                dto.prioridade()
                        )
                        .status(
                                dto.status()
                        )
                        .dataAlerta(
                                LocalDate.now()
                        )
                        .pet(pet)
                        .build();

        return converterParaDTO(
                alertaRepository.save(alerta)
        );
    }

    public Page<AlertaResponseDTO> listar(
            Pageable pageable
    ) {

        return alertaRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    private AlertaResponseDTO converterParaDTO(
            Alerta alerta
    ) {

        return new AlertaResponseDTO(
                alerta.getIdAlerta(),
                alerta.getTipoAlerta(),
                alerta.getMensagem(),
                alerta.getPrioridade(),
                alerta.getDataAlerta(),
                alerta.getStatus(),
                alerta.getPet().getIdPet(),
                alerta.getPet().getNomePet()
        );
    }
}