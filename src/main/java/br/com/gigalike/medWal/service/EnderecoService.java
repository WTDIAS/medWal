package br.com.gigalike.medWal.service;
import br.com.gigalike.medWal.dto.EnderecoDto;
import br.com.gigalike.medWal.erros.NotFound;
import br.com.gigalike.medWal.mapper.EnderecoMapper;
import br.com.gigalike.medWal.model.EnderecoModel;
import br.com.gigalike.medWal.model.MedicoModel;
import br.com.gigalike.medWal.repository.EnderecoRepository;
import br.com.gigalike.medWal.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe que contem as regras de negócio para endereço
 * @author Waldir Tiago
 * */

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private EnderecoMapper enderecoMapper;

    @Transactional
    public EnderecoDto salvar(long idMedico, EnderecoDto enderecoDto){
        MedicoModel medicoModel = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        EnderecoModel enderecoModel = new EnderecoModel(enderecoDto, medicoModel);
        return enderecoMapper.toDto(enderecoRepository.save(enderecoModel));
    }

    @Transactional(readOnly=true)
    public Page<EnderecoDto> listar(long idMedico, Pageable pageable){
        MedicoModel medicoModel = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        if (!medicoModel.isAtivo()){
            throw new NotFound("MedicoModel não encontrado.");
        }
        Page<EnderecoModel> enderecoList = enderecoRepository.findAllByMedicoModelId(idMedico,pageable);
        return enderecoList.map(enderecoMapper::toDto);

    }

    @Transactional
    public EnderecoDto atualizar(long idEndereco, EnderecoDto enderecoDto) {
        EnderecoModel enderecoModel = enderecoRepository.findById(idEndereco).orElseThrow(()->new NotFound("EnderecoModel não encontrado para o id: "+idEndereco));
        return enderecoMapper.toDto(enderecoMapper.update(enderecoDto, enderecoModel));
    }

    @Transactional
    public void deletar(long idEndereco) {
        EnderecoModel enderecoModel = enderecoRepository.findById(idEndereco).orElseThrow(()->new NotFound("EnderecoModel não encontrado para o id: "+idEndereco));
        enderecoRepository.deleteById(enderecoModel.getId());
    }
}
