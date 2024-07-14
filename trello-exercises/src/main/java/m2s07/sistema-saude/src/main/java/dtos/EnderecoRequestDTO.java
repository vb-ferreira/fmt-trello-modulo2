package dtos;

import jakarta.validation.constraints.NotBlank;

public class EnderecoRequestDTO {

    @NotBlank private String logradouro;
    @NotBlank private String estado;
    @NotBlank private String cidade;
    @NotBlank private String numero;
    @NotBlank private String cep;
	
    public @NotBlank String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(@NotBlank String logradouro) {
		this.logradouro = logradouro;
	}
	
	public @NotBlank String getEstado() {
		return estado;
	}
	
	public void setEstado(@NotBlank String estado) {
		this.estado = estado;
	}
	
	public @NotBlank String getCidade() {
		return cidade;
	}
	
	public void setCidade(@NotBlank String cidade) {
		this.cidade = cidade;
	}
	
	public @NotBlank String getNumero() {
		return numero;
	}
	
	public void setNumero(@NotBlank String numero) {
		this.numero = numero;
	}
	
	public @NotBlank String getCep() {
		return cep;
	}
	
	public void setCep(@NotBlank String cep) {
		this.cep = cep;
	}
	
}
