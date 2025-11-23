package br.com.gigalike.medWal.model;
import jakarta.persistence.*;
import lombok.*;

/**
 * Classe UserModel é uma representação de um objeto usuário e da tabela no banco de dados
 * @author Waldir Tiago
 * */


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
public class UserModel {
    @GeneratedValue
    @Id
    long id;
    @Column(name = "login", unique = true, nullable = false)
    String login;
    @Column(name = "senha", unique = true, nullable = false)
    String senha;
}
