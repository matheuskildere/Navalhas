package barbeiros;

/**
 * Barbeiros
 */
public class Barbeiro {
    private int id;
    private String nome;
    public Barbeiro(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}