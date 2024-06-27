package br.senai.petshop.models;

import java.time.LocalDate;
import java.util.Map;

public class Pet {
	
  // instance attributes
  private int id;
  private String nome;
  private String raca;
  private double peso;
  private double altura;
  private String dataNascimento;
  private String especie;
  private Map<LocalDate, Double> historicoPeso;
  private Tutor tutor;
  
  // getters & setters
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

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
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

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  public Map<LocalDate, Double> getHistoricoPeso() {
    return historicoPeso;
  }

  public void setHistoricoPeso(Map<LocalDate, Double> historicoPeso) {
    this.historicoPeso = historicoPeso;
  }

  public Tutor getTutor() {
    return tutor;
  }
	
  public void setTutor(Tutor tutor) {
	this.tutor = tutor;
  }
  
}