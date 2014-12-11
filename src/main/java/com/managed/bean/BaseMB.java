package com.managed.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.web.jsf.FacesContextUtils;

public abstract class BaseMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PAGINA_HOME = "def:privado/home";
	public static final String CRIAR = "criar";
	public static final String EDITAR = "editar";
	public static final String LISTAR = "listar";

	public String getTimeZone() {
		return Calendar.getInstance().getTimeZone().getID();
	}

	protected void error(final String message) {
		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, message,
								message));
	}

	protected void info(final String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	protected <T> T getSpringBean(final String nome) {
		return (T) FacesContextUtils.getRequiredWebApplicationContext(
				FacesContext.getCurrentInstance()).getBean(nome);
	}

	protected SessaoDoUsuario getSessaoDoUsuario() {
		return (SessaoDoUsuario) getSpringBean("SessaoDoUsuario");
	}

}
