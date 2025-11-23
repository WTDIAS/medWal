package br.com.gigalike.medWal.mapper;

import br.com.gigalike.medWal.dto.EnderecoDto;
import br.com.gigalike.medWal.model.EnderecoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Interface EnderecoMapper é utilizada para converter de entity para dto e vice versa, e na atualização
 * dos dados de endereço.
 * @author Waldir Tiago
 * */

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDto toDto(EnderecoModel enderecoModel);
    EnderecoModel toEntity(EnderecoDto enderecoDto);
    List<EnderecoDto> toListDto(List<EnderecoModel> enderecoModelList);

    @Mapping(target = "id", ignore = true)
    EnderecoModel update(EnderecoDto enderecoDto, @MappingTarget EnderecoModel enderecoModel);
}
