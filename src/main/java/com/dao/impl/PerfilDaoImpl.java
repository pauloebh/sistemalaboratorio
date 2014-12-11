package com.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.dao.IPerfilDao;
import com.model.Perfil;

public class PerfilDaoImpl extends AbstractDaoImpl<Perfil> implements IPerfilDao, Serializable {

	private static final long serialVersionUID = 1L;

    protected Class<Perfil> getEntityClass() {
        return Perfil.class;
    }
 
	public Perfil recuperar(Perfil perfil) {
		return recuperar(perfil.getId());
	}

	public Perfil recuperarPorNome(Perfil perfil) {
		
		String nome = perfil.getNome();
		Query q = getSession().createQuery(
				"from Perfil where nome=:nome");

		q.setParameter("nome", nome);

		try {
			return (Perfil) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("Nome informado retornou mais de 1 resultado");
		}

	}

	public List<Perfil> todos() {
		List list = getSession().createQuery("from Perfil").list();
		return Collections.unmodifiableList(list);
	}

}
