package br.com.gigalike.medWal.model;

import br.com.gigalike.medWal.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.*;

/**
 * Classe EnderecoModel é uma representação de um objeto endereço e da tabela no banco de dados
 * @author Waldir Tiago
 * */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "endereco")
public class EnderecoModel {
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
    private MedicoModel medicoModel;

    public EnderecoModel(EnderecoDto enderecoDto, MedicoModel medicoModel) {
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
        this.complemento = enderecoDto.complemento();
        this.numero = enderecoDto.numero();
        this.medicoModel = medicoModel;
    }
}
