package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.consulta.ConsultaRequestDTO;
import br.com.clyvocareai.dto.consulta.ConsultaResponseDTO;
import br.com.clyvocareai.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultaResponseDTO criar(
            @RequestBody
            @Valid
            ConsultaRequestDTO dto
    ) {

        return consultaService.criar(dto);
    }

    @GetMapping
    public Page<ConsultaResponseDTO> listar(
            Pageable pageable
    ) {

        return consultaService.listar(pageable);
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return consultaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(
            @PathVariable Long id
    ) {

        consultaService.deletar(id);
    }
}