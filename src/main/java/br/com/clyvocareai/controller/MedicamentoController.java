package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.medicamento.MedicamentoRequestDTO;
import br.com.clyvocareai.dto.medicamento.MedicamentoResponseDTO;
import br.com.clyvocareai.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicamentoResponseDTO criar(
            @RequestBody
            @Valid
            MedicamentoRequestDTO dto
    ) {

        return medicamentoService.criar(dto);
    }

    @GetMapping
    public Page<MedicamentoResponseDTO> listar(
            Pageable pageable
    ) {

        return medicamentoService.listar(pageable);
    }
}