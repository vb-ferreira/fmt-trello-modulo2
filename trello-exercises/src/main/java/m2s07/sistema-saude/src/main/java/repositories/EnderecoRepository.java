package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
