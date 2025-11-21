package br.com.gigalike.medWal.mapper;

import br.com.gigalike.medWal.dto.EnderecoDto;
import br.com.gigalike.medWal.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDto toDto(Endereco endereco);
    Endereco toEntity(EnderecoDto enderecoDto);
    List<EnderecoDto> toListDto(List<Endereco> enderecoList);

    @Mapping(target = "id", ignore = true)
    Endereco update(EnderecoDto enderecoDto, @MappingTarget Endereco endereco);
}
