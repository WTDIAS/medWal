package br.com.gigalike.medWal.repository;
import br.com.gigalike.medWal.model.EnderecoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de acesso ao dados do banco de dados
 * @author Waldir Tiago
 * */

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel,Long> {
    Page<EnderecoModel> findAllByMedicoModelId(long idMedico, Pageable pageable);
}
