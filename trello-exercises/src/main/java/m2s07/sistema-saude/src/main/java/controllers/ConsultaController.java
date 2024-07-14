package controllers;

import java.util.List;

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

import dtos.ConsultaRequestDTO;
import dtos.ConsultaResponseDTO;
import dtos.mappers.ConsultaMapper;
import jakarta.validation.Valid;
import models.Consulta;
import services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ConsultaMapper consultaMapper;
	
	@GetMapping("/")
	public ResponseEntity<List<ConsultaResponseDTO>> buscarTodos() {
		List<Consulta> consulta = consultaService.buscarTodos(); 
		List<ConsultaResponseDTO> consultaList = consultaMapper.consultasToDTO(consulta);
		return ResponseEntity.status(HttpStatus.OK).body(consultaList);
	}
	
	@PostMapping("/")
	public ResponseEntity<ConsultaResponseDTO> salvar(@RequestBody @Valid ConsultaRequestDTO consultaRequestDTO) {
		Consulta consulta = consultaMapper.consultaToEntity(consultaRequestDTO);
		Consulta consultaGravada = consultaService.salvar(consulta);
		ConsultaResponseDTO consultaResponseDTO = consultaMapper.consultaToDTO(consultaGravada);
		return ResponseEntity.status(HttpStatus.CREATED).body(consultaResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) {
		Consulta consultaGravada = consultaService.buscarPorId(id);
		ConsultaResponseDTO consultaResponseDTO = consultaMapper.consultaToDTO(consultaGravada);
		return ResponseEntity.status(HttpStatus.OK).body(consultaResponseDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, 
		@RequestBody @Valid ConsultaRequestDTO consultaRequestDTO) {
		Consulta consulta = consultaMapper.consultaToEntity(consultaRequestDTO);
		Consulta consultaGravada = consultaService.alterar(id, consulta);
		ConsultaResponseDTO consultaResponseDTO = consultaMapper.consultaToDTO(consultaGravada);
		return ResponseEntity.status(HttpStatus.OK).body(consultaResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) {
		consultaService.apagar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Consulta removida com sucesso");
	}

}
