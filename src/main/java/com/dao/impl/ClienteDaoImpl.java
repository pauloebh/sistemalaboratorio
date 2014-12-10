package com.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import com.dao.IClienteDao;
import com.model.Cliente;

public class ClienteDaoImpl extends AbstractDaoImpl<Cliente> implements IClienteDao, Serializable {

	private static final long serialVersionUID = 1L;

    protected Class<Cliente> getEntityClass() {
        return Cliente.class;
    }
 
	public Cliente recuperar(Cliente usuario) {
		return recuperar(usuario.getId());
	}

	public Cliente recuperarPorCpfCnpj(Cliente cliente) {
		
		String cpfcnpj = cliente.getCpfcnpj();
		Query q = getSession().createQuery(
				"from Cliente where cpfcnpj=:cpfcnpj");

		q.setParameter("cpfcnpj", cpfcnpj);

		try {
			return (Cliente) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("CPF/CNPJ informado retornou mais de 1 resultado");
		}

	}

	public List<Cliente> todos() {
		List list = getSession().createQuery("from Cliente").list();
		return Collections.unmodifiableList(list);
	}

}
