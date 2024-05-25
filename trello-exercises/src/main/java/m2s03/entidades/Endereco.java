package m2s03.entidades;

/**
 * Ex2: Criar a classe Endereco
 */
public class Endereco {

    private String logradouro;
    private String cidade;
    private String estado;
    private int numero;
    private String cep;

    // Default constructor
    public Endereco() {}

    // All-args constructor
    public Endereco(String logradouro, String cidade, String estado, int numero, String cep) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.cep = cep;
    }

    // Getters and Setters

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
