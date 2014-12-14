package com.dao;

import com.model.Usuario;

import java.util.List;

public interface IUsuarioDao extends InterfaceDao<Usuario> {
 
    public Usuario recuperar(Usuario usuario);
    public Usuario recuperarPorEmail(Usuario usuario);
    public Boolean buscaPorLogin(Usuario usuario);
    List<Usuario> todos();
}
