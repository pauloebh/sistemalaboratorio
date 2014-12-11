package com.dao;

import java.util.List;

import com.model.Funcao;

public interface IFuncaoDao extends InterfaceDao<Funcao> {
 
    public Funcao recuperar(Funcao funcao);
    public Funcao recuperarPorNome(Funcao funcao);
    List<Funcao> todos();
    
}
