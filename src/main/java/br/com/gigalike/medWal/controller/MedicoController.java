package br.com.gigalike.medWal.controller;

import br.com.gigalike.medWal.dto.MedicoDto;
import br.com.gigalike.medWal.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDto> cadastrar(@RequestBody @Valid MedicoDto medicoDto, UriComponentsBuilder uriBuilder) {
        MedicoDto medicoDtoSalvo = medicoService.salvar(medicoDto);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medicoDtoSalvo.id()).toUri();
        return ResponseEntity.created(uri).body(medicoDtoSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDto>> listar(Pageable pageable) {
        var resposta = medicoService.listar(pageable);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{idMedico}")
    public ResponseEntity<MedicoDto> atualizar(@PathVariable long idMedico, @RequestBody MedicoDto medicoDto) {
        MedicoDto medicoDtoAtualizado = medicoService.atualizar(idMedico, medicoDto);
        return ResponseEntity.ok(medicoDtoAtualizado);
    }

    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Void> delete(@PathVariable long idMedico) {
        medicoService.delete(idMedico);
        return ResponseEntity.noContent().build();
    }
}
