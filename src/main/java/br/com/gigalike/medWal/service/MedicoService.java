package br.com.gigalike.medWal.service;
import br.com.gigalike.medWal.dto.MedicoDto;
import br.com.gigalike.medWal.erros.NotFound;
import br.com.gigalike.medWal.mapper.MedicoMapper;
import br.com.gigalike.medWal.model.MedicoModel;
import br.com.gigalike.medWal.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe que contem as regras de negócio para médico
 * @author Waldir Tiago
 * */

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    @Transactional
    public MedicoDto salvar(MedicoDto medicoDto){
        MedicoModel medicoModel = medicoMapper.toEntity(medicoDto);
        return medicoMapper.toDto(medicoRepository.save(medicoModel));
    }

    @Transactional(readOnly = true)
    public Page<MedicoDto> listar(Pageable pageable) {
        Page<MedicoModel> medicos = medicoRepository.findAllByAtivoTrue(pageable);
        return medicos.map(medicoMapper::toDto);
    }

    @Transactional
    public MedicoDto atualizar(long idMedico,MedicoDto medicoDto) {
        MedicoModel medicoModel = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        return medicoMapper.toDto(medicoMapper.update(medicoDto, medicoModel));
    }

    @Transactional
    public void delete(long idMedico) {
        MedicoModel medicoModel = medicoRepository.findById(idMedico).orElseThrow(()->new NotFound("Médico não encontrado com id: "+idMedico));
        medicoModel.setAtivo(false);
    }
}
