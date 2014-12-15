package com.managed.bean;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.model.Usuario;
import com.service.IUsuarioService;
import com.util.JsfUtil;
import com.util.Message;

public class LoginMB extends BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "welcome";
	private static final String USUARIO_LOGADO = "usuarioLogado";
	public static final String REDIRECT_TROCA_SENHA = "/pages/adm/senha.jsf?faces-redirect=true";

	private Usuario usuario;
	private String senhaNova;
	private String confirmaSenhaNova;

	private IUsuarioService usuarioService;

	public LoginMB(IUsuarioService usuarioService) {
		setUsuarioService(usuarioService);
		setUsuario(new Usuario());
	}

	public String getConfirmaSenhaNova() {
		return this.confirmaSenhaNova;
	}

	public void setConfirmaSenhaNova(String confirmaSenhaNova) {
		this.confirmaSenhaNova = confirmaSenhaNova;
	}

	public String getSenhaNova() {
		return this.senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IUsuarioService getUsuarioService() {
		return this.usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	public String efetuaLogin() {
		if (getUsuario().getEmail() == null || getUsuario().getSenha() == null) {
			Message.addMessage("login.userEpassw.required");
			return null;
		}

		if (getUsuarioService().buscaPorLogin(getUsuario())) {

            setUsuario(getUsuarioService().getByEmail(getUsuario()));

			JsfUtil.setSessionValue(USUARIO_LOGADO, getUsuario());

			// verifica se contem 5 caracteres conforme a senha default
			if (getUsuario().getSenha().length() == 5) {
				if (getUsuario().getSenha().equals(
						getUsuario().getSenha().replace(".", "").replace("-", "")
						.substring(0, 5))) {
					Message.addMessageConfig("cadastroUsuario.senha.senhaDefault");
					return REDIRECT_TROCA_SENHA;
				} else {
					return SUCCESS;
				}
			} else {
				return SUCCESS;
			}

		} else {
			Message.addMessage("login.invalido");
			return null;
		}
	}

	public String preparaAlteracaoSenha(){
		return "alterasenha";
	}

	public String alteraSenha() {

		if (getUsuario().getSenha() == "") {
			Message.addMessage("login.passw.atual");
			return null;
		} else if (usuarioService.buscaPorLogin(this.usuario) ) {
			Message.addMessage("login.passw.atual");
			return null;
		} else if (getSenhaNova() == "") {
			Message.addMessage("login.passw.nova");
			return null;
		} else if (getConfirmaSenhaNova() == "") {
			Message.addMessage("login.passw.confirm");
			return null;
		} else if (!getSenhaNova().equals(getConfirmaSenhaNova())) {
			Message.addMessage("login.passw.confirmError");
			return null;
		} else {
			getUsuario().setSenha(getSenhaNova());
			getUsuarioService().atualizar(getUsuario());
			Message.addMessageConfig("login.passw.confirmOk");
			return "/pages/wellcome.jsf?faces-redirect=true";
		}
	}

	public String logOut() {

		setUsuario(new Usuario());

		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

		context.invalidateSession();

		JsfUtil.removeFromSession(USUARIO_LOGADO);

		return "/pages/login?faces-redirect=true";    
	}

}
