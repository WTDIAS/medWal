package br.com.gigalike.medWal.mapper;
import br.com.gigalike.medWal.dto.MedicoDto;
import br.com.gigalike.medWal.model.MedicoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

/**
 * Interface MedicoMapper é utilizada para converter de entity para dto e vice versa, e na atualização
 * dos dados de medico.
 * @author Waldir Tiago
 * */

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoDto toDto(MedicoModel medicoModel);
    MedicoModel toEntity(MedicoDto medicoDto);
    List<MedicoDto> toListDto(List<MedicoModel> medicoModelList);

    @Mapping(target = "id",ignore = true)
    MedicoModel update(MedicoDto medicoDto, @MappingTarget MedicoModel medicoModel);
}
