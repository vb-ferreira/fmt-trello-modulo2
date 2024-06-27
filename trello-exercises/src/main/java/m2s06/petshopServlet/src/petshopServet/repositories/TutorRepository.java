package petshopServet.repositories;

import java.util.ArrayList;
import java.util.List;

import petshopServlet.entities.Tutor;

public class TutorRepository {
	
	private static List<Tutor> tutores = new ArrayList<>();
	private static int ultimoIdTutor;
	
	public List<Tutor> listarTutores() {
		return tutores;
	}

	public void adicionarTutor(Tutor tutor) {
		tutor.setId(++ultimoIdTutor);
	    tutores.add(tutor);
	}

	public void removerTutor(Tutor tutor) {
		tutores.remove(tutor);
	}
	  
	public Tutor buscar(int id) {
		return tutores.stream().filter(tutor -> id == tutor.getId()).findFirst().orElse(null);
	}

}
