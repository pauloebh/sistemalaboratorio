package com.managed.bean;

import java.io.Serializable;

import com.model.Usuario;
import com.service.IUserService;


public class SessaoDoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private IUserService usuarioService;

	private Usuario usuarioLogado;

    public SessaoDoUsuario(IUserService service) {
    	setUsuarioService(service);
    	setUsuarioLogado(null);
    }
    
    public boolean isUsuarioLogado() {
        return usuarioLogado != null ? true : false;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;

        //this.permissoes = papelService.getPapelResultante(usuarioLogado);
    }

    public IUserService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUserService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
    /*public Funcao getFuncao() {
        return funcoes;
    }

    public boolean podeCadastrarUsuario() {
         return funcoes contain `cadastrarUsuario`;
        
    }*/
}
