package com.service;

import java.util.List;

import com.model.Cliente;

public interface IClienteService {

	public abstract void adicionar(Cliente cliente);

	public abstract boolean isExiste(Cliente cliente);

	public abstract Cliente recuperar(Integer id);

	public abstract void delete(Cliente cliente);

	public abstract void atualizar(Cliente cliente);

	public abstract Cliente getById(Cliente cliente);

	public abstract Cliente getByCpfCnpj(Cliente cliente);

	public abstract List<Cliente> getAll();

}