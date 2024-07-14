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

import dtos.PacienteRequestDTO;
import dtos.PacienteResponseDTO;
import dtos.mappers.PacienteMapper;
import jakarta.validation.Valid;
import models.Paciente;
import services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteMapper pacienteMapper;
		
	@PostMapping("/")
	public ResponseEntity<PacienteResponseDTO> salvar(@RequestBody @Valid PacienteRequestDTO pacienteRequestDTO) {
		Paciente paciente = pacienteMapper.pacienteToEntity(pacienteRequestDTO);
		Paciente pacienteGravado = pacienteService.salvar(paciente);
		PacienteResponseDTO pacienteResponseDTO = pacienteMapper.pacienteToDTO(pacienteGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) {
		Paciente pacienteGravado = pacienteService.buscarPorId(id);
		PacienteResponseDTO pacienteResponseDTO = pacienteMapper.pacienteToDTO(pacienteGravado);
		return ResponseEntity.status(HttpStatus.OK).body(pacienteResponseDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, 
		@RequestBody @Valid PacienteRequestDTO pacienteRequestDTO) {
		Paciente paciente = pacienteMapper.pacienteToEntity(pacienteRequestDTO);
		Paciente pacienteGravado = pacienteService.alterar(id, paciente);
		PacienteResponseDTO pacienteResponseDTO = pacienteMapper.pacienteToDTO(pacienteGravado);
		return ResponseEntity.status(HttpStatus.OK).body(pacienteResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) {
		pacienteService.apagar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Paciente removido com sucesso");
	}
	
}
