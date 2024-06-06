package m2s04.entities;

public class Medico {

    // Attributes
    private String nome;
    private String crm;
    private Integer idade;
    private String telefone;
    private String especialidade;

    // Default Constructor
    public Medico() {}

    // All-args constructor
    public Medico(String nome, String crm, Integer idade, String telefone, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.idade = idade;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}