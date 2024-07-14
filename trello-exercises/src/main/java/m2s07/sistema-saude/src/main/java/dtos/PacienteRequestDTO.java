package dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.validation.constraints.NotBlank;

public class PacienteRequestDTO {

	@NotBlank private String nome;
	@NotBlank private String cpf;
	@NotBlank private String telefone;
	@NotBlank private String email;
    
    @NotBlank
    @JsonDeserialize
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

	public @NotBlank String getNome() {
		return nome;
	}

	public void setNome(@NotBlank String nome) {
		this.nome = nome;
	}

	public @NotBlank String getCpf() {
		return cpf;
	}

	public void setCpf(@NotBlank String cpf) {
		this.cpf = cpf;
	}

	public @NotBlank String getTelefone() {
		return telefone;
	}

	public void setTelefone(@NotBlank String telefone) {
		this.telefone = telefone;
	}

	public @NotBlank String getEmail() {
		return email;
	}

	public void setEmail(@NotBlank String email) {
		this.email = email;
	}

	public @NotBlank LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(@NotBlank LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
