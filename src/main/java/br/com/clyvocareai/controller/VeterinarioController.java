package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.veterinario.VeterinarioRequestDTO;
import br.com.clyvocareai.dto.veterinario.VeterinarioResponseDTO;
import br.com.clyvocareai.service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeterinarioResponseDTO criar(
            @RequestBody
            @Valid
            VeterinarioRequestDTO dto
    ) {

        return veterinarioService.criar(dto);
    }

    @GetMapping
    public Page<VeterinarioResponseDTO> listar(
            Pageable pageable
    ) {

        return veterinarioService.listar(pageable);
    }

    @GetMapping("/{id}")
    public VeterinarioResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return veterinarioService.buscarPorId(id);
    }
}