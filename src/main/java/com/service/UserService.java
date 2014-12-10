package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IUserDao;
import com.model.Usuario;

@Transactional(readOnly = true)
public class UserService implements IUserService,Serializable {


    private static final long serialVersionUID = 1L;

    public IUserDao userDAO;
    
    public UserService () {
    }

    @Transactional(readOnly = false)
    public void add(Usuario usuario) {
        userDAO.adicionar(usuario); 		// verifica se existe o ID cadastrado
    }

    public boolean isExiste(Usuario usuario) {
        //Verifica se existe usuario user.getNome()
        if (getByCpf(usuario) != null || getByEmail(usuario) != null)
            return true;
        else
            return false;
    }

    public boolean buscaPorLogin(Usuario usuario) {
        return userDAO.buscaPorLogin(usuario);
    }

    public Usuario recuperar(Integer id) {
        return userDAO.recuperar(id);
    }

    @Transactional(readOnly = false)
    public void delete(Usuario usuario) {
        userDAO.deletar(usuario);
    }

    @Transactional(readOnly = false)
    public void update(Usuario usuario) {
        userDAO.atualizar(usuario);
    }

    public Usuario getById(Usuario usuario) {
        return userDAO.recuperar(usuario);
    }

    public Usuario getByCpf(Usuario usuario) {
        return userDAO.recuperarPorCpf(usuario);
    }

    public Usuario getByEmail(Usuario usuario) {
        return userDAO.recuperarPorEmail(usuario);
    }

    public List<Usuario> getAll() {
        return userDAO.todos();
    }

    public void setUserDAO(IUserDao userDAO) {
        this.userDAO = userDAO;
    }
}
