package com.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IUsuarioDao;
import com.model.Usuario;
import com.service.IUsuarioService;

@Transactional(readOnly = true)
public class UsuarioService implements Serializable, IUsuarioService {


    private static final long serialVersionUID = 1L;

    public IUsuarioDao dao;
    
    public UsuarioService () {
    }

    @Transactional(readOnly = false)
    public void adicionar(Usuario usuario) {
    	usuario.setSenha(getDefaultPassword(usuario.getEmail()));
        dao.adicionar(usuario); 		// verifica se existe o ID cadastrado
    }

    private String getDefaultPassword(String email) {
    	   //Senha default  composto pelos 5 primeiros numeros do CPF
        return email.replace(".","").replace("-", "").substring(0, 5);
	}

public void resetSenha(Usuario usuario){
	usuario.setSenha(getDefaultPassword(usuario.getEmail()));
	dao.atualizar(usuario);
}
    
    
	public boolean isExiste(Usuario usuario) {
        //Verifica se existe usuario user.getNome()
        if (getByEmail(usuario) != null)
            return true;
        else
            return false;
    }

    public boolean buscaPorLogin(Usuario usuario) {
        return dao.buscaPorLogin(usuario);
    }

    public Usuario recuperar(Integer id) {
        return dao.recuperar(id);
    }

    @Transactional(readOnly = false)
    public void delete(Usuario usuario) {
        dao.deletar(usuario);
    }

    @Transactional(readOnly = false)
    public void atualizar(Usuario usuario) {
        dao.atualizar(usuario);
    }

    public Usuario getById(Usuario usuario) {
        return dao.recuperar(usuario);
    }

    public Usuario getByEmail(Usuario usuario) {
        return dao.recuperarPorEmail(usuario);
    }

    public List<Usuario> getAll() {
        return dao.todos();
    }

    public void setUserDAO(IUsuarioDao dao) {
        this.dao = dao;
    }
}
