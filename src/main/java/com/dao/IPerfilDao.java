package com.dao;

import java.util.List;

import com.model.Perfil;

public interface IPerfilDao extends InterfaceDao<Perfil> {
 
    public Perfil recuperar(Perfil Perfil);
    public Perfil recuperarPorNome(Perfil Perfil);
    List<Perfil> todos();
}
