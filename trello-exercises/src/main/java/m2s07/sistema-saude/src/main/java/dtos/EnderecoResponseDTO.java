package dtos;

public class EnderecoResponseDTO {
	
	private Long enderecoId;
    private String logradouro;
    private String estado;
    private String cidade;
    private String numero;
    private String cep;
	
    public Long getEnderecoId() {
		return enderecoId;
	}
	
	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
    
}
