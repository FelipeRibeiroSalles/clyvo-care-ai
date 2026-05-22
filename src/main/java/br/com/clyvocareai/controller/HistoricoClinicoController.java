package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.historico.HistoricoClinicoRequestDTO;
import br.com.clyvocareai.dto.historico.HistoricoClinicoResponseDTO;
import br.com.clyvocareai.service.HistoricoClinicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historicos")
@RequiredArgsConstructor
public class HistoricoClinicoController {

    private final HistoricoClinicoService historicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricoClinicoResponseDTO criar(
            @RequestBody
            @Valid
            HistoricoClinicoRequestDTO dto
    ) {

        return historicoService.criar(dto);
    }

    @GetMapping
    public Page<HistoricoClinicoResponseDTO> listar(
            Pageable pageable
    ) {

        return historicoService.listar(pageable);
    }
}