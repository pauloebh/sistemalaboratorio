package com.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.model.Funcao;

public interface IFuncaoService {

	public abstract void add(Funcao Funcao);

	public abstract boolean isExiste(Funcao Funcao);

	public abstract Funcao recuperar(Integer id);

	public abstract void delete(Funcao Funcao);

	public abstract void update(Funcao Funcao);

	public abstract Funcao getById(Funcao Funcao);

	public abstract Funcao getByNome(Funcao Funcao);

	public abstract List<Funcao> getAll();

}