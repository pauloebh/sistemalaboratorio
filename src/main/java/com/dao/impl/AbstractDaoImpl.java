package com.dao.impl;

import com.dao.InterfaceDao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDaoImpl<T> implements InterfaceDao<T> {

    protected abstract Class<T> getEntityClass();

    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public T recuperar(Serializable id) {
        return (T) getSession().load(getEntityClass(), id);
    }

    public T adicionar(T t) {
        return (T) getSession().save(t);
    }

    public T atualizar(T t) {
        return (T) getSession().merge(t);
    }

    public void deletar(T t) {
        getSession().delete(t);
    }
}
