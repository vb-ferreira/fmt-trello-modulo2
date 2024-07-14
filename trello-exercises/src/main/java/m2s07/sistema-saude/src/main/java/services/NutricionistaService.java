package services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import models.Nutricionista;
import repositories.NutricionistaRepository;

@Service
public class NutricionistaService {

	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	public Nutricionista salvar(Nutricionista nutricionista) {
		if (nutricionistaRepository.findByNome(nutricionista.getNome()).isPresent()) {
			throw new DataIntegrityViolationException("Nutricionista já cadastrado.");
		}
		return nutricionistaRepository.save(nutricionista);
	}
	
	public Nutricionista buscarPorId(Long id) {
		Optional<Nutricionista> opt = nutricionistaRepository.findById(id);
		return opt.get();
	}
	
	public Nutricionista alterar(Long id, Nutricionista nutricionista) {
		Nutricionista nutricionistaRegistrado = buscarPorId(id);
		BeanUtils.copyProperties(nutricionista, nutricionistaRegistrado, "id");
		return nutricionistaRepository.save(nutricionistaRegistrado);
	}
	
	public void apagar(Long id) {
		Nutricionista nutricionistaRegistrado = buscarPorId(id);
		nutricionistaRepository.save(nutricionistaRegistrado);
	}
	
    public void adicionarAnoExperiencia(Long id) {
    	Optional<Nutricionista> opt = nutricionistaRepository.findById(id);
        Nutricionista nutricionistaRegistrado = opt.get();
        nutricionistaRegistrado.setTempoExperiencia(nutricionistaRegistrado.getTempoExperiencia() + 1);
    }

    public void adicionarCertificacao(String novaCertificacao, Long id){
    	Optional<Nutricionista> opt = nutricionistaRepository.findById(id);
        Nutricionista nutricionistaRegistrado = opt.get();
        Set<String> certificacoes = nutricionistaRegistrado.getCertificacoes();
        certificacoes.add(novaCertificacao);
        nutricionistaRegistrado.setCertificacoes(certificacoes);
    }

}
