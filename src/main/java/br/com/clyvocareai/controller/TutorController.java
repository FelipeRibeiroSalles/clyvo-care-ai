package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.tutor.TutorRequestDTO;
import br.com.clyvocareai.dto.tutor.TutorResponseDTO;
import br.com.clyvocareai.service.TutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TutorResponseDTO criar(
            @RequestBody
            @Valid
            TutorRequestDTO dto
    ) {

        return tutorService.criar(dto);
    }

    @GetMapping
    public Page<TutorResponseDTO> listar(
            Pageable pageable
    ) {

        return tutorService.listar(pageable);
    }

    @GetMapping("/{id}")
    public TutorResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return tutorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public TutorResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody
            @Valid
            TutorRequestDTO dto
    ) {

        return tutorService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(
            @PathVariable Long id
    ) {

        tutorService.deletar(id);
    }
}