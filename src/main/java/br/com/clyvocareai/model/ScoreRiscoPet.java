package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_SCORES_RISCO_PETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreRiscoPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SCORE")
    private Long idScore;

    @Column(name = "SCORE_RISCO", nullable = false)
    private Double scoreRisco;

    @Column(name = "CLASSIFICACAO", nullable = false)
    private String classificacao;

    @Column(name = "DATA_CALCULO")
    private LocalDate dataCalculo;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;
}