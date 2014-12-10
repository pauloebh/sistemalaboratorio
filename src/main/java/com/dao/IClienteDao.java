package com.dao;

import java.util.List;

import com.model.Cliente;

public interface IClienteDao extends InterfaceDao<Cliente> {
 
    public Cliente recuperar(Cliente cliente);
    public Cliente recuperarPorCpfCnpj(Cliente cliente);
    List<Cliente> todos();
}
