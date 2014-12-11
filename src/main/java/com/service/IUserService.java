package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.model.Usuario;

public interface IUserService {

	public abstract void add(Usuario usuario);

	public abstract boolean isExiste(Usuario usuario);

	public abstract boolean buscaPorLogin(Usuario usuario);

	public abstract Usuario recuperar(Integer id);

	public abstract void delete(Usuario usuario);

	public abstract void update(Usuario usuario);

	public abstract Usuario getById(Usuario usuario);

	public abstract Usuario getByCpf(Usuario usuario);

	public abstract Usuario getByEmail(Usuario usuario);

	public abstract List<Usuario> getAll();

}