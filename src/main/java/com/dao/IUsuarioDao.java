package com.dao;

import com.model.Usuario;

import java.util.List;

public interface IUsuarioDao extends InterfaceDao<Usuario> {
     Usuario recuperar(Usuario usuario);
     Usuario recuperarPorEmail(Usuario usuario);
     Boolean buscaPorLogin(Usuario usuario);
    List<Usuario> todos();
}
