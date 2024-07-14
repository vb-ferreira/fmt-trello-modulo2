package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Consulta;
import repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public Consulta salvar(Consulta consulta) {
		return consultaRepository.save(consulta);
	}
	
	public Consulta buscarPorId(Long id) {
		Optional<Consulta> opt = consultaRepository.findById(id);
		return opt.get();
	}
	
	public List<Consulta> buscarTodos() {
		return consultaRepository.findAll();
	}
	
	public Consulta alterar(Long id, Consulta consulta) {
		Consulta consultaRegistrada = buscarPorId(id);
		BeanUtils.copyProperties(consulta, consultaRegistrada, "id");
		return consultaRepository.save(consultaRegistrada);
	}
	
	public void apagar(Long id) {
		Consulta consultaRegistrada = buscarPorId(id);
		consultaRepository.save(consultaRegistrada);
	}

}
