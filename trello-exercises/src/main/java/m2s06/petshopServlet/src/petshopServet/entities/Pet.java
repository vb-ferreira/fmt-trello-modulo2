package petshopServlet.entities;

public class Pet {
	
	private int id;
    private String nome;
    private String especie;
    private String raca;
    private String sexo;
    private String dataNascimento;
    private double peso;
    private Tutor tutor;
    
    public Pet() { }
    
	public Pet(String nome, String especie, String raca, String sexo, String dataNascimento, double peso) {
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	@Override
	public String toString() {
		return "PET [ "
				+ "Id: " + id 
				+ ", Nome: " + nome 
				+ ", Espécie: " + especie 
				+ ", Raça: " + raca 
				+ ", Sexo: " + sexo
				+ ", Data de nascimento: " + dataNascimento 
				+ ", Peso: " + peso 
				+ ", Tutor: " + tutor + " ]";
	}
    
}
