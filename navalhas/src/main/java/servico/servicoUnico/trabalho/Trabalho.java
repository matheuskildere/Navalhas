package servico.servicoUnico.trabalho;

/**
 * Trabalho
 */
public class Trabalho {

    private int id;
    private String nome;

    public Trabalho(String nome){
        this.nome = nome;
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

    
}