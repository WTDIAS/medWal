package br.com.gigalike.medWal.repository;

import br.com.gigalike.medWal.model.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de acesso ao dados do banco de dados
 * @author Waldir Tiago
 * */

@Repository
public interface AuthRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel> findByLogin(String login);
}
