package dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ConsultaResponseDTO {
	
	private Long consultaId;
	private Long nutricionistaId;
    private Long pacienteId;
    private String observacoes;
    
    @JsonDeserialize
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataConsulta;

	public Long getConsultaId() {
		return consultaId;
	}

	public void setConsultaId(Long consultaId) {
		this.consultaId = consultaId;
	}

	public Long getNutricionistaId() {
		return nutricionistaId;
	}

	public void setNutricionistaId(Long nutricionistaId) {
		this.nutricionistaId = nutricionistaId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
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
