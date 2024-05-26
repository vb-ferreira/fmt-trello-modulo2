package m2s03.entidades;

import java.time.LocalDateTime;

/**
 * Ex. 06 - Criar a classe Consulta
 */
public class Consulta {

    private String nomePaciente;
    private String nomeNutricionista;
    private LocalDateTime dataHora;
    private boolean consultaRealizada;

    public Consulta() {}

    public Consulta(String nomePaciente, String nomeNutricionista, String dataHora, boolean consultaRealizada) {
        this.nomePaciente = nomePaciente;
        this.nomeNutricionista = nomeNutricionista;
        this.dataHora = LocalDateTime.parse(dataHora);
        this.consultaRealizada = consultaRealizada;
    }

    // Getters e Setters
    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeNutricionista() {
        return nomeNutricionista;
    }

    public void setNomeNutricionista(String nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }
}
