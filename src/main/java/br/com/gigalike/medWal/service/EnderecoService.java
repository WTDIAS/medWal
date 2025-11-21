package br.com.gigalike.medWal.service;
import br.com.gigalike.medWal.dto.EnderecoDto;
import br.com.gigalike.medWal.erros.NotFound;
import br.com.gigalike.medWal.mapper.EnderecoMapper;
import br.com.gigalike.medWal.model.Endereco;
import br.com.gigalike.medWal.model.Medico;
import br.com.gigalike.medWal.repository.EnderecoRepository;
import br.com.gigalike.medWal.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        Endereco endereco = new Endereco(enderecoDto,medico);
        return enderecoMapper.toDto(enderecoRepository.save(endereco));
    }

    @Transactional(readOnly=true)
    public Page<EnderecoDto> listar(long idMedico, Pageable pageable){
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        if (!medico.isAtivo()){
            throw new NotFound("Medico não encontrado.");
        }
        Page<Endereco> enderecoList = enderecoRepository.findAllByMedicoId(idMedico,pageable);
        return enderecoList.map(enderecoMapper::toDto);

    }

    @Transactional
    public EnderecoDto atualizar(long idEndereco, EnderecoDto enderecoDto) {
        Endereco endereco = enderecoRepository.findById(idEndereco).orElseThrow(()->new NotFound("Endereco não encontrado para o id: "+idEndereco));
        return enderecoMapper.toDto(enderecoMapper.update(enderecoDto,endereco));
    }

    @Transactional
    public void deletar(long idEndereco) {
        Endereco endereco = enderecoRepository.findById(idEndereco).orElseThrow(()->new NotFound("Endereco não encontrado para o id: "+idEndereco));
        enderecoRepository.deleteById(endereco.getId());
    }
}
