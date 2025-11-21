package br.com.gigalike.medWal.mapper;
import br.com.gigalike.medWal.dto.MedicoDto;
import br.com.gigalike.medWal.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoDto toDto(Medico medico);
    Medico toEntity(MedicoDto medicoDto);
    List<MedicoDto> toListDto(List<Medico> medicoList);

    @Mapping(target = "id",ignore = true)
    Medico update(MedicoDto medicoDto, @MappingTarget Medico medico);
}
