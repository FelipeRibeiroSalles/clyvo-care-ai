package br.com.clyvocareai.dto.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TutorRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nomeTutor,

        @NotBlank(message = "CPF é obrigatório")
        String cpfTutor,

        @Email(message = "Email inválido")
        String emailTutor,

        String telefoneTutor,

        LocalDate dataNascimentoTutor

) {
}