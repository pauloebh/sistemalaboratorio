package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.model.Perfil;

public interface IPerfilService {

	public abstract void add(Perfil perfil);

	public abstract boolean isExiste(Perfil perfil);

	public abstract Perfil recuperar(Integer id);

	public abstract void delete(Perfil perfil);

	public abstract void update(Perfil perfil);

	public abstract Perfil getById(Perfil perfil);

	public abstract Perfil getByNome(Perfil perfil);

	public abstract List<Perfil> getAll();

}