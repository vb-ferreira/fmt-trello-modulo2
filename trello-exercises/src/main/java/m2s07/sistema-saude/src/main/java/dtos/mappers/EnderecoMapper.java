package dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dtos.EnderecoRequestDTO;
import dtos.EnderecoResponseDTO;
import models.Endereco;

@Component
public class EnderecoMapper {

	@Autowired
	private ModelMapper mapper;
	
	// Single Resources
	
	public Endereco enderecoToEntity(EnderecoRequestDTO dto) {
		Endereco entity = mapper.map(dto, Endereco.class);
		return entity;
	}
	
	public EnderecoResponseDTO enderecoToDTO(Endereco entity) {
		EnderecoResponseDTO dto = mapper.map(entity, EnderecoResponseDTO.class);
		return dto;
	}
	
}
