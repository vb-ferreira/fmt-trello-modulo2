package m2s03.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Ex. 04: Criar a classe Nutricionista
 */
public class Nutricionista extends Funcionario {

    private List<String> certificacoes;
    private int numeroConsultas;
    private int experiencia;

    public Nutricionista() {}

    public Nutricionista(String nome, int idade, Endereco endereco, double salario, int numeroConsultas, int experiencia) {
        super(nome, idade, endereco, salario);
        this.certificacoes = new ArrayList<>();
        this.numeroConsultas = numeroConsultas;
        this.experiencia = experiencia;
    }

    /**
     * Ex. 05 - adiciona 1 ano ao tempo de experiência.
     */
    public void adicionarExperiencia() {
        experiencia++;
    }

    /**
     * Ex. 05 - adiciona certificação à lista de certificações.
     * @param certificacao string com certificação.
     */
    public void adicionarCertificacao(String certificacao) {
        certificacoes.add(certificacao);
    }

    // Getters e Setters
    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
