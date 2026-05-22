package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_TUTORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TUTOR")
    private Long idTutor;

    @Column(name = "NOME_TUTOR", nullable = false)
    private String nomeTutor;

    @Column(name = "CPF_TUTOR", nullable = false, unique = true)
    private String cpfTutor;

    @Column(name = "EMAIL_TUTOR", nullable = false, unique = true)
    private String emailTutor;

    @Column(name = "TELEFONE_TUTOR")
    private String telefoneTutor;

    @Column(name = "DATA_NASCIMENTO_TUTOR")
    private LocalDate dataNascimentoTutor;

    @Column(name = "DT_CADASTRO_TUTOR")
    private LocalDate dtCadastroTutor;
}