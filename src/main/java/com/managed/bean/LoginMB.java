package com.managed.bean;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.model.Usuario;
import com.service.IUserService;
import com.util.JsfUtil;
import com.util.Message;

public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "welcome";
	private static final String USUARIO_LOGADO = "usuarioLogado";
	public static final String REDIRECT_TROCA_SENHA = "/pages/adm/senha.jsf?faces-redirect=true";

	private Usuario usuario;
	private String senhaNova;
	private String confirmaSenhaNova;

	private IUserService userService;

	public LoginMB(IUserService userService) {
		setUserService(userService);
		setUser(new Usuario());
	}
	
	public IUserService getUserService() {
		return this.userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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

	public Usuario getUser() {
		return this.usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String efetuaLogin() {
		if (getUser().getEmail() == null || getUser().getSenha() == null) {
			Message.addMessage("login.userEpassw.required");
			return null;
		}

		if (getUserService().buscaPorLogin(getUser())) {

            setUser(getUserService().getByEmail(getUser()));

			JsfUtil.setSessionValue(USUARIO_LOGADO, getUser());

			// verifica se contem 5 caracteres conforme a senha default
			if (getUser().getSenha().length() == 5) {
				if (getUser().getSenha().equals(
						getUser().getSenha().replace(".", "").replace("-", "")
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

		if (getUser().getSenha() == "") {
			Message.addMessage("login.passw.atual");
			return null;
		} else if (userService.buscaPorLogin(this.usuario) ) {
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
			getUser().setSenha(getSenhaNova());
			getUserService().update(getUser());
			Message.addMessageConfig("login.passw.confirmOk");
			return "/pages/wellcome.jsf?faces-redirect=true";
		}
	}

	public String logOut() {

		setUser(new Usuario());

		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

		context.invalidateSession();

		JsfUtil.removeFromSession(USUARIO_LOGADO);

		return "/pages/login?faces-redirect=true";    
	}

}
