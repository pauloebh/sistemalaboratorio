package com.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.model.Cliente;
import com.service.IClienteService;
import com.util.Message;


public class ClienteMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;

	private List<Cliente> clienteList;

	private IClienteService clienteService;

	public ClienteMB(IClienteService clienteService) {
		setClienteService(clienteService);
		setCliente(new Cliente());
	}

	public void limpar() {
		setCliente(new Cliente());
	}

	public String novo() {
		setCliente(new Cliente());
		return CRIAR;
	}

	public String adicionar() {

		// se o usuario existir atualiza
		if (getCliente().getId() != 0) {
			// selecaoToPerfilEnum(this.user);
			getClienteService().update(getCliente());
			return LISTAR;
			// valida se existe p/adicionar
		} else if (!getClienteService().isExiste(getCliente())) {

			// /selecaoToPerfilEnum(this.user);
			getClienteService().add(getCliente());
			return LISTAR;
		} else {
			Message.addMessage("cadastroUsuario.existente");
			return null;
		}
	}

	public String deletar(Cliente cliente) {
		getClienteService().delete(cliente);
		return null;
	}

	public String atualizar(Cliente cliente) {
		getClienteService().update(cliente);
		return CRIAR;
	}

	public String editar(Cliente cliente) {
		setCliente(cliente);
		return EDITAR;
	}

	public String listaClientes() {
		return LISTAR;
	}

	public String getLabelCadastro() {
		if (getCliente().getId() == 0) {
			return Message.getBundleMessage("cadastroUsuario.label.titulo");
		} else {
			return Message
					.getBundleMessage("cadastroUsuario.label.alteraUsuario");
		}
	}

	public void reset() {
		setCliente(new Cliente());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteList() {
		this.clienteList = new ArrayList<Cliente>();
		this.clienteList.addAll(getClienteService().getAll());
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	private IClienteService getClienteService() {
		return clienteService;
	}

	private void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

}
