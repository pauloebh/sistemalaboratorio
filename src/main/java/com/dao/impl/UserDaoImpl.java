package com.dao.impl;

import com.dao.IUserDao;
import com.model.User;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl extends AbstractDaoImpl<User> implements IUserDao, Serializable {

	private static final long serialVersionUID = 1L;

    protected Class<User> getEntityClass() {
        return User.class;
    }
 
	public User recuperar(User user) {
		return recuperar(user.getUserId());
	}

	public User recuperarPorCpf(User user) {
		
		String cpf = user.getCpf();
		Query q = getSession().createQuery(
				"from User where cpf=:cpf");

		q.setParameter("cpf", cpf);

		try {
			return (User) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("CPF informado retornou mais de 1 resultado");
		}

	}

	public User recuperarPorEmail(User user) {
		
		String email = user.getEmail();

		Query q = getSession().createQuery(
				"from User where email=:email");

		q.setParameter("email", email);

		try {
			return (User) q.uniqueResult();
		} catch (NonUniqueResultException e) {
			throw new IllegalArgumentException("Email informado retornou mais de 1 resultado");
		}

	}

	public Boolean buscaPorLogin(User user) {

		Query q = getSession().createQuery(
                "from User u where u.email = :pLogin and u.senha = :pSenha");

		q.setParameter("pLogin", user.getEmail());
		q.setParameter("pSenha", user.getSenha());

		try {
            User p = (User) q.uniqueResult();
			if (p == null) {
				return false;
			} else {
				return true;
			}
		} catch (NonUniqueResultException e) {
			throw new RuntimeException("Ocorreu um erro ao tentar encontrar o usu�rio");
		}

	}

	public List<User> todos() {
		List list = getSession().createQuery("from User").list();
		return Collections.unmodifiableList(list);
	}

}
