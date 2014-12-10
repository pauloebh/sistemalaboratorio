package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IClienteDao;
import com.dao.IUserDao;
import com.model.Cliente;
import com.model.Usuario;

@Transactional(readOnly = true)
public class ClienteService implements IClienteService,Serializable {


    private static final long serialVersionUID = 1L;

    public IClienteDao clienteDAO;
    
    public ClienteService () {
    }

    @Transactional(readOnly = false)
    public void add(Cliente cliente) {
        clienteDAO.adicionar(cliente); 		// verifica se existe o ID cadastrado
    }

    public boolean isExiste(Cliente cliente) {
        //Verifica se existe usuario user.getNome()
        if (getByCpfCnpj(cliente) != null)
            return true;
        else
            return false;
    }

    public Cliente recuperar(Integer id) {
        return clienteDAO.recuperar(id);
    }

    @Transactional(readOnly = false)
    public void delete(Cliente cliente) {
        clienteDAO.deletar(cliente);
    }

    @Transactional(readOnly = false)
    public void update(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    public Cliente getById(Cliente cliente) {
        return clienteDAO.recuperar(cliente);
    }

    public Cliente getByCpfCnpj(Cliente cliente) {
        return clienteDAO.recuperarPorCpfCnpj(cliente);
    }

    public List<Cliente> getAll() {
        return clienteDAO.todos();
    }

    public void setClienteDAO(IClienteDao clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
}
