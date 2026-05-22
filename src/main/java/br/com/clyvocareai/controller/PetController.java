package br.com.clyvocareai.controller;

import br.com.clyvocareai.dto.pet.PetRequestDTO;
import br.com.clyvocareai.dto.pet.PetResponseDTO;
import br.com.clyvocareai.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponseDTO criar(
            @RequestBody
            @Valid
            PetRequestDTO dto
    ) {

        return petService.criar(dto);
    }

    @GetMapping
    public Page<PetResponseDTO> listar(
            Pageable pageable
    ) {

        return petService.listar(pageable);
    }

    @GetMapping("/{id}")
    public PetResponseDTO buscarPorId(
            @PathVariable Long id
    ) {

        return petService.buscarPorId(id);
    }

    @GetMapping("/tutor/{idTutor}")
    public List<PetResponseDTO> listarPorTutor(
            @PathVariable Long idTutor
    ) {

        return petService.listarPorTutor(idTutor);
    }

    @GetMapping("/buscar")
    public Page<PetResponseDTO> filtrarPorNome(
            @RequestParam String nome,
            Pageable pageable
    ) {

        return petService.filtrarPorNome(
                nome,
                pageable
        );
    }

    @PutMapping("/{id}")
    public PetResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody
            @Valid
            PetRequestDTO dto
    ) {

        return petService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(
            @PathVariable Long id
    ) {

        petService.deletar(id);
    }
}