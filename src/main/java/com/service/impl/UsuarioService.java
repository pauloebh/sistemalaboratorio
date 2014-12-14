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

    public IUsuarioDao userDAO;
    
    public UsuarioService () {
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#add(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void add(Usuario usuario) {
        userDAO.adicionar(usuario); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#isExiste(com.model.Usuario)
	 */
    public boolean isExiste(Usuario usuario) {
        //Verifica se existe usuario user.getNome()
        if (getByEmail(usuario) != null)
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#buscaPorLogin(com.model.Usuario)
	 */
    public boolean buscaPorLogin(Usuario usuario) {
        return userDAO.buscaPorLogin(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#recuperar(java.lang.Integer)
	 */
    public Usuario recuperar(Integer id) {
        return userDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#delete(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void delete(Usuario usuario) {
        userDAO.deletar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#update(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void update(Usuario usuario) {
        userDAO.atualizar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#getById(com.model.Usuario)
	 */
    public Usuario getById(Usuario usuario) {
        return userDAO.recuperar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#getByEmail(com.model.Usuario)
	 */
    public Usuario getByEmail(Usuario usuario) {
        return userDAO.recuperarPorEmail(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUsuarioService#getAll()
	 */
    public List<Usuario> getAll() {
        return userDAO.todos();
    }

    public void setUserDAO(IUsuarioDao userDAO) {
        this.userDAO = userDAO;
    }
}
