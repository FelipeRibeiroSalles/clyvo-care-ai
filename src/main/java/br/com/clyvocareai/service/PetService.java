package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.pet.PetRequestDTO;
import br.com.clyvocareai.dto.pet.PetResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Pet;
import br.com.clyvocareai.model.Tutor;
import br.com.clyvocareai.repository.PetRepository;
import br.com.clyvocareai.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;

    public PetResponseDTO criar(
            PetRequestDTO dto
    ) {

        Tutor tutor =
                tutorRepository.findById(
                        dto.idTutor()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tutor não encontrado"
                        ));

        Pet pet =
                Pet.builder()
                        .nomePet(dto.nomePet())
                        .especie(dto.especie())
                        .raca(dto.raca())
                        .sexo(dto.sexo())
                        .cor(dto.cor())
                        .peso(dto.peso())
                        .dataNascimentoPet(
                                dto.dataNascimentoPet()
                        )
                        .statusSaude(
                                dto.statusSaude()
                        )
                        .tutor(tutor)
                        .build();

        return converterParaDTO(
                petRepository.save(pet)
        );
    }

    public Page<PetResponseDTO> listar(
            Pageable pageable
    ) {

        return petRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    public List<PetResponseDTO> listarPorTutor(
            Long idTutor
    ) {

        return petRepository
                .findByTutorIdTutor(idTutor)
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public Page<PetResponseDTO> filtrarPorNome(
            String nomePet,
            Pageable pageable
    ) {

        return petRepository
                .findByNomePetContainingIgnoreCase(
                        nomePet,
                        pageable
                )
                .map(this::converterParaDTO);
    }

    public PetResponseDTO buscarPorId(
            Long id
    ) {

        Pet pet =
                petRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Pet não encontrado"
                                ));

        return converterParaDTO(pet);
    }

    public PetResponseDTO atualizar(
            Long id,
            PetRequestDTO dto
    ) {

        Pet pet =
                petRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Pet não encontrado"
                                ));

        Tutor tutor =
                tutorRepository.findById(
                        dto.idTutor()
                ).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Tutor não encontrado"
                        ));

        pet.setNomePet(
                dto.nomePet()
        );

        pet.setEspecie(
                dto.especie()
        );

        pet.setRaca(
                dto.raca()
        );

        pet.setSexo(
                dto.sexo()
        );

        pet.setCor(
                dto.cor()
        );

        pet.setPeso(
                dto.peso()
        );

        pet.setDataNascimentoPet(
                dto.dataNascimentoPet()
        );

        pet.setStatusSaude(
                dto.statusSaude()
        );

        pet.setTutor(tutor);

        return converterParaDTO(
                petRepository.save(pet)
        );
    }

    public void deletar(Long id) {

        Pet pet =
                petRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Pet não encontrado"
                                ));

        petRepository.delete(pet);
    }

    private PetResponseDTO converterParaDTO(
            Pet pet
    ) {

        return new PetResponseDTO(
                pet.getIdPet(),
                pet.getNomePet(),
                pet.getEspecie(),
                pet.getRaca(),
                pet.getSexo(),
                pet.getCor(),
                pet.getPeso(),
                pet.getDataNascimentoPet(),
                pet.getStatusSaude(),
                pet.getTutor().getIdTutor(),
                pet.getTutor().getNomeTutor()
        );
    }
}