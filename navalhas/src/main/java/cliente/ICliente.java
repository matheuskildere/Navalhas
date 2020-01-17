package cliente;

/**
 * ICliente
 */
public interface ICliente {

    /**
     * Add a new service on people list
     * @param per
     */
    public void add(Cliente nome);

    /**
     * Catch the person with the cpf informed
     * @param cpf
     * @return a object type of person
     */
    public Cliente get(String nome);
    
    /**
     * @param codigo
     * @return ArrayList with client's information
     */
    public Object[] getInfo(String nome);

    /**
     * modify informations of Person
     * @param cpf
     * @param per
     */
    public void set(String nome, Cliente cliente);

    /**
     * Remove Person with cpf informed of people list
     * @param cpf
     */
    public void remove(String nome);
}