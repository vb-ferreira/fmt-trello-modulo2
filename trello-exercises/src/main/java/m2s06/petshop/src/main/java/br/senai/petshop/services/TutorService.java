package br.senai.petshop.services;

import java.util.List;
import org.springframework.stereotype.Service;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.repositories.TutorRepository;

@Service
public class TutorService {

	  // instance attributes	
	  private final TutorRepository tutorRepository;
	  
	  // constructor with DI
	  public TutorService(TutorRepository tutorRepository) {
	      this.tutorRepository = tutorRepository;
	  }

	  // methods
	  public void cadastrar(Tutor tutor) {
	      tutorRepository.adicionarTutor(tutor);
	  }

	  public List<Tutor> listar() {
	      return tutorRepository.listar();
	  }

	  public Tutor buscar(int id) {
	      return tutorRepository.buscar(id);
	  }

	  public boolean excluir(int id) {
	      var tutorExcluir = tutorRepository.buscar(id);
	      if (tutorExcluir != null) {
	          tutorRepository.removerTutor(tutorExcluir);
	          return true;
	      }
	      return false;
	  }
	  
	  public boolean atualizar(Tutor tutor) {
	      var tutorAtualizar = tutorRepository.buscar(tutor.getId());
		  if (tutorAtualizar != null) {
		      tutorAtualizar.setNome(tutor.getNome());
		      return true;
		  }
	      return false;
	  }

}
