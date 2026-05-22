package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.alerta.AlertaRequestDTO;
import br.com.clyvocareai.dto.alerta.AlertaResponseDTO;
import br.com.clyvocareai.service.AlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService alertaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertaResponseDTO criar(
            @RequestBody
            @Valid
            AlertaRequestDTO dto
    ) {

        return alertaService.criar(dto);
    }

    @GetMapping
    public Page<AlertaResponseDTO> listar(
            Pageable pageable
    ) {

        return alertaService.listar(pageable);
    }
}