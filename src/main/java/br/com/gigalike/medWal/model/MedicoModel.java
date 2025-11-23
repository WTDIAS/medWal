package br.com.gigalike.medWal.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Classe MedicoModel é uma representação de um objeto médico e da tabela no banco de dados
 * @author Waldir Tiago
 * */


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name = "medico")
public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private boolean ativo;

    @OneToMany(mappedBy = "medicoModel", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EnderecoModel> enderecoModelList;
}
