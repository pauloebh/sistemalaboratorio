package com.managed.bean;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;
 
import com.model.Funcao;
import com.service.IFuncaoService;
import com.util.Message;

public class FuncaoMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcao funcao;

	private List<Funcao> funcaoList;

	private IFuncaoService funcaoService;

	public FuncaoMB(IFuncaoService funcaoService) {
		setFuncaoService((IFuncaoService)funcaoService);
		setFuncao(new Funcao());
	}

	public void limpar() {
		setFuncao(new Funcao());
	}

	public String novo() {
		setFuncao(new Funcao());
		return CRIAR;
	}

	public String adicionar() {

		// se o usuario existir atualiza
		if (getFuncao().getId() != 0) {
			// selecaoToFuncaoEnum(this.user);
			getFuncaoService().update(getFuncao());
			return LISTAR;
			// valida se existe p/adicionar
		} else if (!getFuncaoService().isExiste(getFuncao())) {

			// /selecaoToFuncaoEnum(this.user);
			getFuncaoService().add(getFuncao());
			return LISTAR;
		} else {
			Message.addMessage("cadastroUsuario.existente");
			return null;
		}
	}

	public String deletar(Funcao funcao) {
		getFuncaoService().delete(funcao);
		return null;
	}

	public String atualizar(Funcao funcao) {
		getFuncaoService().update(funcao);
		return CRIAR;
	}

	public String editar(Funcao funcao) {
		setFuncao(funcao);
		return EDITAR;
	}

	public String listaFuncaos() {
		return LISTAR;
	}

	public String getLabelCadastro() {
		if (getFuncao().getId() == 0) {
			return Message.getBundleMessage("cadastroUsuario.label.titulo");
		} else {
			return Message
					.getBundleMessage("cadastroUsuario.label.alteraUsuario");
		}
	}

	public void reset() {
		setFuncao(new Funcao());
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncaoList() {
		this.funcaoList = new ArrayList<Funcao>();
		this.funcaoList.addAll(getFuncaoService().getAll());
		return funcaoList;
	}

	public void setFuncaoList(List<Funcao> list) {
		this.funcaoList = list;
	}

	public IFuncaoService getFuncaoService() {
		return this.funcaoService;
	}

	public void setFuncaoService(IFuncaoService FuncaoService) {
		this.funcaoService = FuncaoService;
	}

}
