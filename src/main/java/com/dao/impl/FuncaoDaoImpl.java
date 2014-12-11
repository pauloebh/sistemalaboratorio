package com.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.dao.IFuncaoDao;
import com.model.Funcao;

public class FuncaoDaoImpl extends AbstractDaoImpl<Funcao> implements IFuncaoDao, Serializable {

	protected Class<Funcao> getEntityClass() {
        return Funcao.class;
    }
 
	public Funcao recuperar(Funcao funcao) {
		return recuperar(funcao.getId());
	}

	public Funcao recuperarPorNome(Funcao funcao) {
		
		String nome = funcao.getNome();
		Query q = getSession().createQuery(
				"from Funcao where nome=:nome");

		q.setParameter("nome", nome);

		try {
			return (Funcao) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("Nome informado retornou mais de 1 resultado");
		}

	}

	public List<Funcao> todos() {
		List list = getSession().createQuery("from Funcao").list();
		return Collections.unmodifiableList(list);
	}

}
