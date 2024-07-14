package dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NutricionistaRequestDTO {
	
	@NotBlank private String nome;
	@NotBlank private String matricula;
	@NotBlank private String crn;
	@NotNull private int tempoExperiencia;
	
	public @NotBlank String getNome() {
		return nome;
	}
	
	public void setNome(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public @NotBlank String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(@NotBlank String matricula) {
		this.matricula = matricula;
	}
	
	public @NotBlank String getCrn() {
		return crn;
	}
	
	public void setCrn(@NotBlank String crn) {
		this.crn = crn;
	}

	public @NotNull int getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(@NotNull int tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}
	
}
