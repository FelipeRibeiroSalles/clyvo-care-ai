package br.com.clyvocareai.service;

import br.com.clyvocareai.dto.tutor.TutorRequestDTO;
import br.com.clyvocareai.dto.tutor.TutorResponseDTO;
import br.com.clyvocareai.exception.ResourceNotFoundException;
import br.com.clyvocareai.model.Tutor;
import br.com.clyvocareai.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorResponseDTO criar(
            TutorRequestDTO dto
    ) {

        Tutor tutor =
                Tutor.builder()
                        .nomeTutor(dto.nomeTutor())
                        .cpfTutor(dto.cpfTutor())
                        .emailTutor(dto.emailTutor())
                        .telefoneTutor(dto.telefoneTutor())
                        .dataNascimentoTutor(
                                dto.dataNascimentoTutor()
                        )
                        .dtCadastroTutor(
                                LocalDate.now()
                        )
                        .build();

        return converterParaDTO(
                tutorRepository.save(tutor)
        );
    }

    public Page<TutorResponseDTO> listar(
            Pageable pageable
    ) {

        return tutorRepository
                .findAll(pageable)
                .map(this::converterParaDTO);
    }

    public TutorResponseDTO buscarPorId(
            Long id
    ) {

        Tutor tutor =
                tutorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Tutor não encontrado"
                                ));

        return converterParaDTO(tutor);
    }

    public TutorResponseDTO atualizar(
            Long id,
            TutorRequestDTO dto
    ) {

        Tutor tutor =
                tutorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Tutor não encontrado"
                                ));

        tutor.setNomeTutor(
                dto.nomeTutor()
        );

        tutor.setCpfTutor(
                dto.cpfTutor()
        );

        tutor.setEmailTutor(
                dto.emailTutor()
        );

        tutor.setTelefoneTutor(
                dto.telefoneTutor()
        );

        tutor.setDataNascimentoTutor(
                dto.dataNascimentoTutor()
        );

        return converterParaDTO(
                tutorRepository.save(tutor)
        );
    }

    public void deletar(Long id) {

        Tutor tutor =
                tutorRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Tutor não encontrado"
                                ));

        tutorRepository.delete(tutor);
    }

    private TutorResponseDTO converterParaDTO(
            Tutor tutor
    ) {

        return new TutorResponseDTO(
                tutor.getIdTutor(),
                tutor.getNomeTutor(),
                tutor.getCpfTutor(),
                tutor.getEmailTutor(),
                tutor.getTelefoneTutor(),
                tutor.getDataNascimentoTutor(),
                tutor.getDtCadastroTutor()
        );
    }
}