package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.vacina.VacinaRequestDTO;
import br.com.clyvocareai.dto.vacina.VacinaResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.model.Vacina;
import br.com.clyvocareai.repository.PetRepository;
import br.com.clyvocareai.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;
    private final PetRepository petRepository;

    public VacinaResponseDTO criar(
            VacinaRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        Vacina vacina =
                Vacina.builder()
                        .nomeVacina(dto.nomeVacina())
                        .fabricante(dto.fabricante())
                        .dose(dto.dose())
                        .dataAplicacao(
                                dto.dataAplicacao()
                        )
                        .proximaDose(
                                dto.proximaDose()
                        )
                        .status(dto.status())
                        .pet(pet)
                        .build();

        return converterParaDTO(
                vacinaRepository.save(vacina)
        );
    }

    public Page<VacinaResponseDTO> listar(
            Pageable pageable
    ) {

        return vacinaRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    private VacinaResponseDTO converterParaDTO(
            Vacina vacina
    ) {

        return new VacinaResponseDTO(
                vacina.getIdVacina(),
                vacina.getNomeVacina(),
                vacina.getFabricante(),
                vacina.getDose(),
                vacina.getDataAplicacao(),
                vacina.getProximaDose(),
                vacina.getStatus(),
                vacina.getPet().getIdPet(),
                vacina.getPet().getNomePet()
        );
    }
}