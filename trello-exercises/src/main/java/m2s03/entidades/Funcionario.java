package m2s03.entidades;

/**
 * Ex3: Criar a classe Funcionario
 */
public class Funcionario {

    private String nome;
    private int idade;
    private Endereco endereco;
    private double salario;

    // Default constructor
    public Funcionario() {}

    // All-args constructor
    public Funcionario(String nome, int idade, Endereco endereco, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.salario = salario;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
