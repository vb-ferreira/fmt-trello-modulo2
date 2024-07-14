package services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Endereco;
import repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco buscarPorId(Long id) {
		Optional<Endereco> opt = enderecoRepository.findById(id);
		return opt.get();
	}
	
	public Endereco alterar(Long id, Endereco endereco) {
		Endereco enderecoRegistrado = buscarPorId(id);
		BeanUtils.copyProperties(endereco, enderecoRegistrado, "id");
		return enderecoRepository.save(enderecoRegistrado);
	}
	
	public void apagar(Long id) {
		Endereco enderecoRegistrado = buscarPorId(id);
		enderecoRepository.save(enderecoRegistrado);
	}
	
}
