package com.service;

import java.util.List;

import com.model.Usuario;

public interface IUserService {
	
	public void add(Usuario usuario);
	public void update(Usuario usuario);
	public void delete(Usuario usuario);
	public Usuario getById(Usuario usuario);
	public Usuario getByCpf(Usuario usuario);
	public Usuario getByEmail(Usuario usuario);
	public List<Usuario> getAll();
    public Usuario recuperar(Integer id);
	public abstract boolean isExiste(Usuario usuario);
	public abstract boolean buscaPorLogin(Usuario usuario);

}
