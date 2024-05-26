package m2s03.entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas;

    // Construtores
    public Paciente() {
        atividadesFisicas = new ArrayList<>();
    }

    public Paciente(String nome, int idade, double peso, double altura, double pressaoArterial, double frequenciaCardiaca, String dietaAlimentar, List<String> atividadesFisicas) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pressaoArterial = pressaoArterial;
        this.frequenciaCardiaca = frequenciaCardiaca;
        this.dietaAlimentar = dietaAlimentar;
        this.atividadesFisicas = atividadesFisicas;
    }

    // Métodos
    public double calcularIMC() {
        double pacientePeso = getPeso();
        double pacienteAltura = getAltura();
        double imc = pacientePeso / (pacienteAltura * pacienteAltura);
        return Math.round(imc * 100.0) / 100.0;
    }

    public void monitorarPaciente() {
        System.out.println("Paciente: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Peso (kg): " + getPeso());
        System.out.println("Altura (m): " + getAltura());
        System.out.println("Pressão Arterial: " + getPressaoArterial());
        System.out.println("Frequência Cardíaca: " + getFrequenciaCardiaca());
        System.out.println("Dieta Alimentar: " + getDietaAlimentar());
        System.out.println("IMC: " + calcularIMC());
        System.out.println("Atividades Físicas: " + atividadesFisicas.toString());
    }

    public void registrarAtividade(String atividade) {
        atividadesFisicas.add(atividade);
    }

    // Getters e Setters
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getDietaAlimentar() {
        return dietaAlimentar;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }
}