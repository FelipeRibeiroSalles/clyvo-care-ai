package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.score.ScoreRiscoPetRequestDTO;
import br.com.clyvocareai.dto.score.ScoreRiscoPetResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.model.ScoreRiscoPet;
import br.com.clyvocareai.repository.PetRepository;
import br.com.clyvocareai.repository.ScoreRiscoPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ScoreRiscoPetService {

    private final ScoreRiscoPetRepository scoreRepository;
    private final PetRepository petRepository;

    public ScoreRiscoPetResponseDTO criar(
            ScoreRiscoPetRequestDTO dto
    ) {

        Pet pet = petRepository.findById(
                dto.idPet()
        ).orElseThrow(() ->
                new ResourceNotFoundException(
                        "Pet não encontrado"
                ));

        ScoreRiscoPet score =
                ScoreRiscoPet.builder()
                        .scoreRisco(
                                dto.scoreRisco()
                        )
                        .classificacao(
                                classificarRisco(
                                        dto.scoreRisco()
                                )
                        )
                        .dataCalculo(
                                LocalDate.now()
                        )
                        .pet(pet)
                        .build();

        return converterParaDTO(
                scoreRepository.save(score)
        );
    }

    public Page<ScoreRiscoPetResponseDTO> listar(
            Pageable pageable
    ) {

        return scoreRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    private String classificarRisco(
            Double score
    ) {

        if (score <= 25) {
            return "BAIXO";
        }

        if (score <= 50) {
            return "MODERADO";
        }

        if (score <= 75) {
            return "ALTO";
        }

        return "CRITICO";
    }

    private ScoreRiscoPetResponseDTO converterParaDTO(
            ScoreRiscoPet score
    ) {

        return new ScoreRiscoPetResponseDTO(
                score.getIdScore(),
                score.getScoreRisco(),
                score.getClassificacao(),
                score.getDataCalculo(),
                score.getPet().getIdPet(),
                score.getPet().getNomePet()
        );
    }
}