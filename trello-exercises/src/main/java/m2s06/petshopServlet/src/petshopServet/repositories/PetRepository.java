package petshopServet.repositories;

import java.util.ArrayList;
import java.util.List;

import petshopServlet.entities.Pet;

public class PetRepository {
	
	private static List<Pet> pets = new ArrayList<>();
	private static int ultimoIdPet;
	
	public List<Pet> listarPets() {
	    return pets;
	  }

	public void adicionarPet(Pet pet) {
		pet.setId(++ultimoIdPet);
		pets.add(pet);
	}

	public void removerPet(Pet pet) {
		pets.remove(pet);
	}
	  
	public Pet buscar(int id) {
		return pets.stream().filter(pet -> id == pet.getId()).findFirst().orElse(null);
	}

}
