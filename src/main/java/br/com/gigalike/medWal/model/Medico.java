package br.com.gigalike.medWal.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {
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

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Endereco> enderecoList;
}
