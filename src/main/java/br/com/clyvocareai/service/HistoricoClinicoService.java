package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.historico.HistoricoClinicoRequestDTO;
import br.com.clyvocareai.dto.historico.HistoricoClinicoResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.HistoricoClinico;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.repository.HistoricoClinicoRepository;
import br.com.clyvocareai.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricoClinicoService {

    private final HistoricoClinicoRepository historicoRepository;
    private final PetRepository petRepository;

    public HistoricoClinicoResponseDTO criar(
            HistoricoClinicoRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        HistoricoClinico historico =
                HistoricoClinico.builder()
                        .descricaoEvento(
                                dto.descricaoEvento()
                        )
                        .categoria(
                                dto.categoria()
                        )
                        .dataEvento(
                                dto.dataEvento()
                        )
                        .nivelRisco(
                                dto.nivelRisco()
                        )
                        .pet(pet)
                        .build();

        return converterParaDTO(
                historicoRepository.save(
                        historico
                )
        );
    }

    public Page<HistoricoClinicoResponseDTO> listar(
            Pageable pageable
    ) {

        return historicoRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    private HistoricoClinicoResponseDTO converterParaDTO(
            HistoricoClinico historico
    ) {

        return new HistoricoClinicoResponseDTO(
                historico.getIdHistorico(),
                historico.getDescricaoEvento(),
                historico.getCategoria(),
                historico.getDataEvento(),
                historico.getNivelRisco(),
                historico.getPet().getIdPet(),
                historico.getPet().getNomePet()
        );
    }
}