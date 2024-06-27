package br.senai.petshop.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.services.TutorService;

@RestController
@RequestMapping("/tutors")
public class TutorController {

	  // instance attributes	
	  private final TutorService tutorService;

	  // constructor with DI
	  public TutorController(TutorService tutorService) {
	    this.tutorService = tutorService;
	  }
	  
	  // methods
	  @PostMapping()
	  public void cadastrar(@RequestBody Tutor tutor) {
	    tutorService.cadastrar(tutor);
	  }

	  @GetMapping()
	  public List<Tutor> buscar() {
	    var tutors = tutorService.listar();
	    if (tutors.isEmpty()) {
	      // return 404
	      return null;
	    } else {
	      return tutors;
	    }
	  }

	  @GetMapping("/{id}")
	  public Tutor buscar(@PathVariable int id) {
	    Tutor tutor = tutorService.buscar(id);

	    if (tutor != null) {
	      return tutor;
	    } else {
	      // return 404
	      return null;
	    }
	  }

	  @DeleteMapping("/{id}")
	  public String excluir(@PathVariable int id) {
	    return tutorService.excluir(id)
	        ? "Excluído com sucesso."
	        : String.format("Tutor não encontrado para id: %d.", id);
	  }

	  @PutMapping
	  public String atualizar(@RequestBody Tutor tutor) {
	    return tutorService.atualizar(tutor)
	        ? "Atualizado com sucesso."
	        : String.format("Tutor não encontrado para id: %d.", tutor.getId());
	  }

}
