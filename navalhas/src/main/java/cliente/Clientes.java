package cliente;

import java.util.ArrayList;

/**
 * Clientes
 */
public class Clientes implements ICliente{

    private ArrayList<Cliente> clientList;

    public Clientes() {
        clientList = new ArrayList<>();
    }

    @Override
    public void add(Cliente nome) {
        clientList.add(nome);
    }

    @Override
    public Cliente get(String nome) {
        for (Cliente cli : clientList) {
            if (nome == cli.getNome()) {
                return cli;
            }
        }
        return null;
    }
    @Override
    public Object[] getInfo(String nome)throws IllegalArgumentException{
        Cliente cliente = get(nome);
        if (cliente !=null) {
            Object[] infoCLi ={cliente.getNome(), cliente.getContato1(),cliente.getContato2(),cliente.getFoto(), cliente.getBiometria()};
            return infoCLi;
        } else {
            throw new IllegalArgumentException("Cliente nao encontrado!");
        }
    }

    @Override
    public void set(String nome, Cliente cliente) throws IllegalArgumentException {
        Cliente old = get(nome);
        if (old != null) {
            remove(nome);
            add(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }

    @Override
    public void remove(String nome) {
        Cliente remove = get(nome);
        if (remove != null) {
            clientList.remove(remove);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }

    public Boolean addNewService(String nome){
        Cliente add = get(nome);
        if (add != null) {
            add.novoServico();
            return add.getServicoGratis();
        } else {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    }
}