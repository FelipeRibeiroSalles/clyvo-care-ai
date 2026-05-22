package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CONSULTAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;

    @Column(name = "DATA_CONSULTA", nullable = false)
    private LocalDateTime dataConsulta;

    @Column(name = "MOTIVO_CONSULTA", nullable = false)
    private String motivoConsulta;

    @Column(name = "DIAGNOSTICO_CONSULTA")
    private String diagnosticoConsulta;

    @Column(name = "OBSERVACOES_CONSULTA")
    private String observacoesConsulta;

    @Column(name = "RETORNO_RECOMENDADO")
    private LocalDateTime retornoRecomendado;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "ID_VETERINARIO", nullable = false)
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "ID_CLINICA", nullable = false)
    private Clinica clinica;
}