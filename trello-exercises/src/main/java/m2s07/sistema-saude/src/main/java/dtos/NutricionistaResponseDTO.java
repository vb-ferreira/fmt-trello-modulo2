package dtos;

public class NutricionistaResponseDTO {

	private Long nutricionistaId;
	private String nome;
	private String matricula;
	private String crn;
	
	public Long getNutricionistaId() {
		return nutricionistaId;
	}
	
	public void setNutricionistaId(Long nutricionistaId) {
		this.nutricionistaId = nutricionistaId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getCrn() {
		return crn;
	}
	
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
}
