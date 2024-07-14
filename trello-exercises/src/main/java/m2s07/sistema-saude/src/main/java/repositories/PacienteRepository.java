package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
