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

import br.senai.petshop.models.Pet;
import br.senai.petshop.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
  
  // instance attributes	
  private final PetService petService;

  // constructor with DI
  public PetController(PetService petService) {
    this.petService = petService;
  }

  // methods
  @PostMapping()
  public void cadastrar(@RequestBody Pet pet) {
    petService.cadastrar(pet);
  }

  @GetMapping()
  public List<Pet> buscar() {
    var pets = petService.listar();
    if (pets.isEmpty()) {
      // return 404
      return null;
    } else {
      return pets;
    }
  }

  @GetMapping("/{id}")
  public Pet buscar(@PathVariable int id) {
    Pet pet = petService.buscar(id);

    if (pet != null) {
      return pet;
    } else {
      // return 404
      return null;
    }
  }

  @DeleteMapping("/{id}")
  public String excluir(@PathVariable int id) {
    return petService.excluir(id)
        ? "Excluído com sucesso."
        : String.format("Pet não encontrado para id: %d.", id);
  }

  @PutMapping
  public String atualizar(@RequestBody Pet pet) {
    return petService.atualizar(pet)
        ? "Atualizado com sucesso."
        : String.format("Pet não encontrado para id: %d.", pet.getId());
  }
  
}