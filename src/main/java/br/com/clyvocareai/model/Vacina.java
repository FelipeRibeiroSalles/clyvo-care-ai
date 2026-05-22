package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_VACINAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VACINA")
    private Long idVacina;

    @Column(name = "NOME_VACINA", nullable = false)
    private String nomeVacina;

    @Column(name = "FABRICANTE")
    private String fabricante;

    @Column(name = "DOSE")
    private String dose;

    @Column(name = "DATA_APLICACAO", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "PROXIMA_DOSE")
    private LocalDate proximaDose;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;
}