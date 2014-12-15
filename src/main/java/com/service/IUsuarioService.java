package com.service;

import java.util.List;

import com.model.Usuario;

public interface IUsuarioService {

	public abstract void adicionar(Usuario usuario);

	public abstract boolean isExiste(Usuario usuario);

	public abstract boolean buscaPorLogin(Usuario usuario);

	public abstract Usuario recuperar(Integer id);
	
	public abstract void resetSenha(Usuario usuario);
	
	public abstract void delete(Usuario usuario);

	public abstract void atualizar(Usuario usuario);

	public abstract Usuario getById(Usuario usuario);

	public abstract Usuario getByEmail(Usuario usuario);

	public abstract List<Usuario> getAll();

}