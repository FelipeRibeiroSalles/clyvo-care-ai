package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.medicamento.MedicamentoRequestDTO;
import br.com.clyvocareai.dto.medicamento.MedicamentoResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Medicamento;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.repository.MedicamentoRepository;
import br.com.clyvocareai.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final PetRepository petRepository;

    public MedicamentoResponseDTO criar(
            MedicamentoRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        Medicamento medicamento =
                Medicamento.builder()
                        .nomeMedicamento(
                                dto.nomeMedicamento()
                        )
                        .dosagem(dto.dosagem())
                        .frequencia(
                                dto.frequencia()
                        )
                        .dataInicio(
                                dto.dataInicio()
                        )
                        .dataFim(dto.dataFim())
                        .observacao(
                                dto.observacao()
                        )
                        .pet(pet)
                        .build();

        return converterParaDTO(
                medicamentoRepository.save(
                        medicamento
                )
        );
    }

    public Page<MedicamentoResponseDTO> listar(
            Pageable pageable
    ) {

        return medicamentoRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    private MedicamentoResponseDTO converterParaDTO(
            Medicamento medicamento
    ) {

        return new MedicamentoResponseDTO(
                medicamento.getIdMedicamento(),
                medicamento.getNomeMedicamento(),
                medicamento.getDosagem(),
                medicamento.getFrequencia(),
                medicamento.getDataInicio(),
                medicamento.getDataFim(),
                medicamento.getObservacao(),
                medicamento.getPet().getIdPet(),
                medicamento.getPet().getNomePet()
        );
    }
}