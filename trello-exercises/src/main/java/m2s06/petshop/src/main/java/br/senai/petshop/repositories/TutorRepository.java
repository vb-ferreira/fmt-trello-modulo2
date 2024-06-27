package br.senai.petshop.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import br.senai.petshop.models.Tutor;

@Repository
public class TutorRepository {

	  // instance attributes
	  private static final List<Tutor> tutors = new ArrayList<>();
	  private static int ultimoId;
	
	  // methods
	  public List<Tutor> listar() {
	    return tutors;
	  }

	  public void adicionarTutor(Tutor tutor) {
	    tutor.setId(++ultimoId);
	    tutors.add(tutor);
	  }

	  public void removerTutor(Tutor tutor) {
	    tutors.remove(tutor);
	  }

	  public Tutor buscar(int id) {
	    return tutors.stream().filter(tutor -> id == tutor.getId()).findFirst().orElse(null);
	  }

}
