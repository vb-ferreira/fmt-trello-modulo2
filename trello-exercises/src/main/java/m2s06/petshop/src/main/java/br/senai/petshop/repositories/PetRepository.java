package br.senai.petshop.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.senai.petshop.models.Pet;
import br.senai.petshop.models.Tutor;
import br.senai.petshop.services.TutorService;

@Repository
public class PetRepository {
  
  // instance attributes
  private static final List<Pet> pets = new ArrayList<>();
  private static int ultimoId;
  @Autowired
  private TutorService tutorService;
  
  // methods
  public List<Pet> listar() {
    return pets;
  }

  public void adicionarPet(Pet pet) {
    pet.setId(++ultimoId);
    pets.add(pet);
  }

  public void removerPet(Pet pet) {
    pets.remove(pet);
  }

  public Pet buscar(int id) {
    return pets.stream().filter(pet -> id == pet.getId()).findFirst().orElse(null);
  }
  
  public void atualizarTutor(int idTutor, int idPet) {
	Tutor tutorFind = tutorService.buscar(idTutor);
	Pet petFind = this.buscar(idPet);
	petFind.setTutor(tutorFind);
  }
  
}