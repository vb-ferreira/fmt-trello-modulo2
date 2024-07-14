package services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Paciente;
import repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente salvar(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	public Paciente buscarPorId(Long id) {
		Optional<Paciente> opt = pacienteRepository.findById(id);
		return opt.get();
	}
	
	public Paciente alterar(Long id, Paciente paciente) {
		Paciente pacienteRegistrado = buscarPorId(id);
		BeanUtils.copyProperties(paciente, pacienteRegistrado, "id");
		return pacienteRepository.save(pacienteRegistrado);
	}
	
	public void apagar(Long id) {
		Paciente pacienteRegistrado = buscarPorId(id);
		pacienteRepository.save(pacienteRegistrado);
	}
	
}
