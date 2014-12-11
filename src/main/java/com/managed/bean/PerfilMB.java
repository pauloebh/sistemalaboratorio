package com.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.model.Perfil;
import com.service.IFuncaoService;
import com.service.IPerfilService;
import com.util.Message;

public class PerfilMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Perfil perfil;

	private List<Perfil> perfilList;

	private IPerfilService perfilService;
	private IFuncaoService funcaoService;


	public PerfilMB(IPerfilService perfilService, IFuncaoService funcaoService) {
		setPerfilService(perfilService);
		setFuncaoService(funcaoService);
		setPerfil(new Perfil());
	}

	public void limpar() {
		setPerfil(new Perfil());
	}

	public String novo() {
		setPerfil(new Perfil());
		return CRIAR;
	}

	public String adicionar() {

		// se o usuario existir atualiza
		if (getPerfil().getId() != 0) {
			// selecaoToPerfilEnum(this.user);
			getPerfilService().update(getPerfil());
			return LISTAR;
			// valida se existe p/adicionar
		} else if (!getPerfilService().isExiste(getPerfil())) {

			// /selecaoToPerfilEnum(this.user);
			getPerfilService().add(getPerfil());
			return LISTAR;
		} else {
			Message.addMessage("cadastroUsuario.existente");
			return null;
		}
	}

	public String deletar(Perfil perfil) {
		getPerfilService().delete(perfil);
		return null;
	}

	public String atualizar(Perfil perfil) {
		getPerfilService().update(perfil);
		return CRIAR;
	}

	public String editar(Perfil perfil) {
		setPerfil(perfil);
		return EDITAR;
	}

	public String listaPerfils() {
		return LISTAR;
	}

	public String getLabelCadastro() {
		if (getPerfil().getId() == 0) {
			return Message.getBundleMessage("cadastroUsuario.label.titulo");
		} else {
			return Message
					.getBundleMessage("cadastroUsuario.label.alteraUsuario");
		}
	}

	public void reset() {
		setPerfil(new Perfil());
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getPerfilList() {
		this.perfilList = new ArrayList<Perfil>();
		this.perfilList.addAll(getPerfilService().getAll());
		return perfilList;
	}

	public void setPerfilList(List<Perfil> PerfilList) {
		this.perfilList = PerfilList;
	}

	public IPerfilService getPerfilService() {
		return this.perfilService;
	}

	public void setPerfilService(IPerfilService PerfilService) {
		this.perfilService = PerfilService;
	}


	public IFuncaoService getFuncaoService() {
		return funcaoService;
	}

	public void setFuncaoService(IFuncaoService funcaoService) {
		this.funcaoService = funcaoService;
	}
}
