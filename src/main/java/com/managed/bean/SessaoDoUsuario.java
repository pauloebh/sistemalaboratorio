package com.managed.bean;

import java.io.Serializable;

import com.model.Usuario;
import com.service.IUsuarioService;


public class SessaoDoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private IUsuarioService usuarioService;

	private Usuario usuarioLogado;

    public SessaoDoUsuario(IUsuarioService service) {
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

    public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
    /*public Funcao getFuncao() {
        return funcoes;
    }

    public boolean podeCadastrarUsuario() {
         return funcoes contain `cadastrarUsuario`;
        
    }*/
}
