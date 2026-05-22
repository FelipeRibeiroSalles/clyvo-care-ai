package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.clinica.ClinicaRequestDTO;
import br.com.clyvocareai.dto.clinica.ClinicaResponseDTO;
import br.com.clyvocareai.service.ClinicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinicas")
@RequiredArgsConstructor
public class ClinicaController {

    private final ClinicaService clinicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicaResponseDTO criar(
            @RequestBody
            @Valid
            ClinicaRequestDTO dto
    ) {

        return clinicaService.criar(dto);
    }

    @GetMapping
    public Page<ClinicaResponseDTO> listar(
            Pageable pageable
    ) {

        return clinicaService.listar(pageable);
    }

    @GetMapping("/{id}")
    public ClinicaResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return clinicaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClinicaResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody
            @Valid
            ClinicaRequestDTO dto
    ) {

        return clinicaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(
            @PathVariable Long id
    ) {

        clinicaService.deletar(id);
    }
}