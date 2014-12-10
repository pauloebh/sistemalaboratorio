package com.dao.impl;

import com.dao.IUserDao;
import com.model.Usuario;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class UsuarioDaoImpl extends AbstractDaoImpl<Usuario> implements IUserDao, Serializable {

	private static final long serialVersionUID = 1L;

    protected Class<Usuario> getEntityClass() {
        return Usuario.class;
    }
 
	public Usuario recuperar(Usuario usuario) {
		return recuperar(usuario.getId());
	}

	public Usuario recuperarPorCpf(Usuario usuario) {
		
		String cpf = usuario.getCpf();
		Query q = getSession().createQuery(
				"from Usuario where cpf=:cpf");

		q.setParameter("cpf", cpf);

		try {
			return (Usuario) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("CPF informado retornou mais de 1 resultado");
		}

	}

	public Usuario recuperarPorEmail(Usuario usuario) {
		
		String email = usuario.getEmail();

		Query q = getSession().createQuery(
				"from Usuario where email=:email");

		q.setParameter("email", email);

		try {
			return (Usuario) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("Email informado retornou mais de 1 resultado");
		}

	}

	public Boolean buscaPorLogin(Usuario usuario) {

		Query q = getSession().createQuery(
                "from Usuario u where u.email = :pLogin and u.senha = :pSenha");

		q.setParameter("pLogin", usuario.getEmail());
		q.setParameter("pSenha", usuario.getSenha());

		try {
            Usuario p = (Usuario) q.uniqueResult();
			if (p == null) {
				return false;
			} else {
				return true;
			}
		} catch (NonUniqueResultException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar encontrar o usu�rio");
		}

	}

	public List<Usuario> todos() {
		List list = getSession().createQuery("from Usuario").list();
		return Collections.unmodifiableList(list);
	}

}
