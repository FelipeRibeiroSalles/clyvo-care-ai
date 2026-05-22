package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_MEDICAMENTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICAMENTO")
    private Long idMedicamento;

    @Column(name = "NOME_MEDICAMENTO", nullable = false)
    private String nomeMedicamento;

    @Column(name = "DOSAGEM")
    private String dosagem;

    @Column(name = "FREQUENCIA")
    private String frequencia;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;
}