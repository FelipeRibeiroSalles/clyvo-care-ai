package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_PETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PET")
    private Long idPet;

    @Column(name = "NOME_PET", nullable = false)
    private String nomePet;

    @Column(name = "ESPECIE", nullable = false)
    private String especie;

    @Column(name = "RACA")
    private String raca;

    @Column(name = "SEXO", nullable = false)
    private String sexo;

    @Column(name = "COR")
    private String cor;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "DATA_NASCIMENTO_PET")
    private LocalDate dataNascimentoPet;

    @Column(name = "STATUS_SAUDE")
    private String statusSaude;

    @ManyToOne
    @JoinColumn(name = "ID_TUTOR", nullable = false)
    private Tutor tutor;
}