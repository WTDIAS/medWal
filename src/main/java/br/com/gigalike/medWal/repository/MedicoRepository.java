package br.com.gigalike.medWal.repository;
import br.com.gigalike.medWal.model.MedicoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de acesso ao dados do banco de dados
 * @author Waldir Tiago
 * */

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel,Long> {
    Page<MedicoModel> findAllByAtivoTrue(Pageable pageable);
}
