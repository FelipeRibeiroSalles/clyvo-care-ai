package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.vacina.VacinaRequestDTO;
import br.com.clyvocareai.dto.vacina.VacinaResponseDTO;
import br.com.clyvocareai.service.VacinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacinas")
@RequiredArgsConstructor
public class VacinaController {

    private final VacinaService vacinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VacinaResponseDTO criar(
            @RequestBody
            @Valid
            VacinaRequestDTO dto
    ) {

        return vacinaService.criar(dto);
    }

    @GetMapping
    public Page<VacinaResponseDTO> listar(
            Pageable pageable
    ) {

        return vacinaService.listar(pageable);
    }
}