package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_ALERTAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERTA")
    private Long idAlerta;

    @Column(name = "TIPO_ALERTA", nullable = false)
    private String tipoAlerta;

    @Column(name = "MENSAGEM", nullable = false)
    private String mensagem;

    @Column(name = "PRIORIDADE", nullable = false)
    private String prioridade;

    @Column(name = "DATA_ALERTA")
    private LocalDate dataAlerta;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private Pet pet;
}