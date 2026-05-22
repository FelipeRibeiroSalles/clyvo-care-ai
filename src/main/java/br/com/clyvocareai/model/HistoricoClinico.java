package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_HISTORICOS_CLINICOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HISTORICO")
    private Long idHistorico;

    @Column(name = "DESCRICAO_EVENTO", nullable = false)
    private String descricaoEvento;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "DATA_EVENTO", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "NIVEL_RISCO")
    private String nivelRisco;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;
}