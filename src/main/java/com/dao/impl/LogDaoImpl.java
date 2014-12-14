package com.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.dao.ILogDao;
import com.model.Log;

public class LogDaoImpl extends AbstractDaoImpl<Log> implements ILogDao, Serializable {

	private static final long serialVersionUID = 1L;

    protected Class<Log> getEntityClass() {
        return Log.class;
    }
 
	public Log recuperar(Log Log) {
		return recuperar(Log.getId());
	}

	/*@SuppressWarnings("unchecked")
	public List<Log> recuperarPorUsuario(Log Log) {
		
		Integer idUsuario = Log.getUsuario().getId();
		Query q = getSession().createQuery(
				"from Log where usuario=:usuario");
		q.setParameter("usuario", idUsuario);

		try {
			List list = q.list();
			return Collections.unmodifiableList(list);
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("Nome informado retornou mais de 1 resultado");
		}

	}*/

	public List<Log> todos() {
		List list = getSession().createQuery("from Log").list();
		return Collections.unmodifiableList(list);
	}

}
