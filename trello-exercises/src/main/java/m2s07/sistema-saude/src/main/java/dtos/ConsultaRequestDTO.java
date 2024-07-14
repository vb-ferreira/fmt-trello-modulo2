package dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ConsultaRequestDTO {
	
    @NotNull private Long nutricionistaId;
    @NotNull private Long pacienteId;
    private String observacoes;
    
    @NotBlank
    @JsonDeserialize
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConsulta;

	public @NotNull Long getNutricionistaId() {
		return nutricionistaId;
	}

	public void setNutricionistaId(@NotNull Long nutricionistaId) {
		this.nutricionistaId = nutricionistaId;
	}

	public @NotNull Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(@NotNull Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
}
