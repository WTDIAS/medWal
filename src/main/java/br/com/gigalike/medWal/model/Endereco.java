package br.com.gigalike.medWal.model;

import br.com.gigalike.medWal.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Endereco(EnderecoDto enderecoDto, Medico medico) {
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
        this.complemento = enderecoDto.complemento();
        this.numero = enderecoDto.numero();
        this.medico = medico;
    }
}
