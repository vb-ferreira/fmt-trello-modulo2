package dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dtos.NutricionistaRequestDTO;
import dtos.NutricionistaResponseDTO;
import models.Nutricionista;

@Component
public class NutricionistaMapper {

	@Autowired
	private ModelMapper mapper;
	
	// Single Resources
	
	public Nutricionista nutricionistaToEntity(NutricionistaRequestDTO dto) {
		Nutricionista entity = mapper.map(dto, Nutricionista.class);
		return entity;
	}
	
	public NutricionistaResponseDTO nutricionistaToDTO(Nutricionista entity) {
		NutricionistaResponseDTO dto = mapper.map(entity, NutricionistaResponseDTO.class);
		return dto;
	}
		
}
