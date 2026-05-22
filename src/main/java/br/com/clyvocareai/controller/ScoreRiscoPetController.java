package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.score.ScoreRiscoPetRequestDTO;
import br.com.clyvocareai.dto.score.ScoreRiscoPetResponseDTO;
import br.com.clyvocareai.service.ScoreRiscoPetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreRiscoPetController {

    private final ScoreRiscoPetService scoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreRiscoPetResponseDTO criar(
            @RequestBody
            @Valid
            ScoreRiscoPetRequestDTO dto
    ) {

        return scoreService.criar(dto);
    }

    @GetMapping
    public Page<ScoreRiscoPetResponseDTO> listar(
            Pageable pageable
    ) {

        return scoreService.listar(pageable);
    }
}