package br.com.clyvocareai.dto.tutor;

import java.time.LocalDate;

public record TutorResponseDTO(

        Long idTutor,
        String nomeTutor,
        String cpfTutor,
        String emailTutor,
        String telefoneTutor,
        LocalDate dataNascimentoTutor,
        LocalDate dtCadastroTutor

) {
}