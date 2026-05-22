package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_VETERINARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VETERINARIO")
    private Long idVeterinario;

    @Column(name = "NOME_VETERINARIO", nullable = false)
    private String nomeVeterinario;

    @Column(name = "CRMV", nullable = false, unique = true)
    private String crmv;

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @Column(name = "EMAIL_VETERINARIO")
    private String emailVeterinario;

    @Column(name = "TELEFONE_VETERINARIO")
    private String telefoneVeterinario;

    @ManyToOne
    @JoinColumn(name = "ID_CLINICA", nullable = false)
    private Clinica clinica;
}