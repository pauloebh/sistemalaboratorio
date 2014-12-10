package com.service;

import java.util.List;

import com.model.Cliente;

public interface IClienteService {
	
	public void add(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
	public Cliente getById(Cliente cliente);
	public Cliente getByCpfCnpj(Cliente cliente);
	public List<Cliente> getAll();
    public Cliente recuperar(Integer id);
	public abstract boolean isExiste(Cliente cliente);

}
