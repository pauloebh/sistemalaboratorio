package com.dao;

import java.io.Serializable;
 
public interface AbstractDao<T> {
    T recuperar(Serializable id);
    T adicionar(T t);
    T atualizar(T t);
    void deletar(T t);
}
