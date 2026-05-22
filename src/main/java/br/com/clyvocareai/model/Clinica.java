package br.com.clyvocareai.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CLINICAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLINICA")
    private Long idClinica;

    @Column(name = "NOME_FANTASIA", nullable = false)
    private String nomeFantasia;

    @Column(name = "CNPJ", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "TELEFONE_CLINICA")
    private String telefoneClinica;

    @Column(name = "EMAIL_CLINICA")
    private String emailClinica;

    @Column(name = "ENDERECO_CLINICA", nullable = false)
    private String enderecoClinica;
}