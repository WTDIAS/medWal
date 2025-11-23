package br.com.gigalike.medWal.controller;
import br.com.gigalike.medWal.dto.EnderecoDto;
import br.com.gigalike.medWal.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Classe EnderecoController contem os endpoints CRUD para manipular dados de um endereço
 * @author Waldir Tiago
 * */

@RestController
@RequestMapping("/enderecos")
public class EderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idMedico}")
    public ResponseEntity<EnderecoDto> salvar(@PathVariable long idMedico, @RequestBody @Valid EnderecoDto enderecoDto, UriComponentsBuilder uriBuilder){
        EnderecoDto enderecoDtoSalvo = enderecoService.salvar(idMedico,enderecoDto);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(enderecoDtoSalvo.id()).toUri();
        return ResponseEntity.created(uri).body(enderecoDtoSalvo);
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<Page<EnderecoDto>> listarEnderecosDoMedico(@PathVariable long idMedico, Pageable pageable){
        var retorno = enderecoService.listar(idMedico,pageable);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDto> atualizar(@PathVariable long idEndereco, @RequestBody @Valid EnderecoDto enderecoDto){
        EnderecoDto enderecoDtoAtualizado = enderecoService.atualizar(idEndereco,enderecoDto);
        return ResponseEntity.ok(enderecoDtoAtualizado);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable long idEndereco){
        enderecoService.deletar(idEndereco);
        return ResponseEntity.noContent().build();
    }
}
