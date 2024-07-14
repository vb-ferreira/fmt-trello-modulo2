package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Nutricionista;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
	
	Optional<Nutricionista> findByNome(String nome);

}
