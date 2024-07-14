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

import dtos.EnderecoRequestDTO;
import dtos.EnderecoResponseDTO;
import dtos.mappers.EnderecoMapper;
import jakarta.validation.Valid;
import models.Endereco;
import services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private EnderecoMapper enderecoMapper;
		
	@PostMapping("/")
	public ResponseEntity<EnderecoResponseDTO> salvar(@RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO) {
		Endereco endereco = enderecoMapper.enderecoToEntity(enderecoRequestDTO);
		Endereco enderecoGravado = enderecoService.salvar(endereco);
		EnderecoResponseDTO enderecoResponseDTO = enderecoMapper.enderecoToDTO(enderecoGravado);
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable(value = "id") Long id) {
		Endereco enderecoGravado = enderecoService.buscarPorId(id);
		EnderecoResponseDTO enderecoResponseDTO = enderecoMapper.enderecoToDTO(enderecoGravado);
		return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable(value = "id") Long id, 
		@RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO) {
		Endereco endereco = enderecoMapper.enderecoToEntity(enderecoRequestDTO);
		Endereco enderecoGravado = enderecoService.alterar(id, endereco);
		EnderecoResponseDTO enderecoResponseDTO = enderecoMapper.enderecoToDTO(enderecoGravado);
		return ResponseEntity.status(HttpStatus.OK).body(enderecoResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagar(@PathVariable(value = "id") Long id) {
		enderecoService.apagar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Endereco removido com sucesso");
	}
	
}
