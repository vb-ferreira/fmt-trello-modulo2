package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dtos.NutricionistaRequestDTO;
import dtos.NutricionistaResponseDTO;
import dtos.mappers.NutricionistaMapper;
import jakarta.validation.Valid;
import models.Nutricionista;
import services.NutricionistaService;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

	@Autowired
	private NutricionistaService nutricionistaService;
	
	@Autowired
	private NutricionistaMapper nutricionistaMapper;
		
	@PostMapping("/")
	public ResponseEntity<NutricionistaResponseDTO> salvar(@RequestBody @Valid NutricionistaRequestDTO nutricionistaRequestDTO) {
		Nutricionista nutricionista = nutricionistaMapper.nutricionistaToEntity(nutricionistaRequestDTO);
		Nutricionista nutricionistaGravado = nutricionistaService.salvar(nutricionista);
		NutricionistaResponseDTO nutricionistaResponseDTO = nutricionistaMapper.nutricionistaToDTO(nutricionistaGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(nutricionistaResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) {
		Nutricionista nutricionistaGravado = nutricionistaService.buscarPorId(id);
		NutricionistaResponseDTO nutricionistaResponseDTO = nutricionistaMapper.nutricionistaToDTO(nutricionistaGravado);
		return ResponseEntity.status(HttpStatus.OK).body(nutricionistaResponseDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, 
		@RequestBody @Valid NutricionistaRequestDTO nutricionistaRequestDTO) {
		Nutricionista nutricionista = nutricionistaMapper.nutricionistaToEntity(nutricionistaRequestDTO);
		Nutricionista nutricionistaGravado = nutricionistaService.alterar(id, nutricionista);
		NutricionistaResponseDTO nutricionistaResponseDTO = nutricionistaMapper.nutricionistaToDTO(nutricionistaGravado);
		return ResponseEntity.status(HttpStatus.OK).body(nutricionistaResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) {
		nutricionistaService.apagar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Nutricionista removido com sucesso");
	}
	
}
