package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IUserDao;
import com.model.Usuario;

@Transactional(readOnly = true)
public class UserService implements Serializable, IUserService {


    private static final long serialVersionUID = 1L;

    public IUserDao userDAO;
    
    public UserService () {
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#add(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void add(Usuario usuario) {
        userDAO.adicionar(usuario); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#isExiste(com.model.Usuario)
	 */
    public boolean isExiste(Usuario usuario) {
        //Verifica se existe usuario user.getNome()
        if (getByCpf(usuario) != null || getByEmail(usuario) != null)
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#buscaPorLogin(com.model.Usuario)
	 */
    public boolean buscaPorLogin(Usuario usuario) {
        return userDAO.buscaPorLogin(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#recuperar(java.lang.Integer)
	 */
    public Usuario recuperar(Integer id) {
        return userDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#delete(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void delete(Usuario usuario) {
        userDAO.deletar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#update(com.model.Usuario)
	 */
    @Transactional(readOnly = false)
    public void update(Usuario usuario) {
        userDAO.atualizar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#getById(com.model.Usuario)
	 */
    public Usuario getById(Usuario usuario) {
        return userDAO.recuperar(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#getByCpf(com.model.Usuario)
	 */
    public Usuario getByCpf(Usuario usuario) {
        return userDAO.recuperarPorCpf(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#getByEmail(com.model.Usuario)
	 */
    public Usuario getByEmail(Usuario usuario) {
        return userDAO.recuperarPorEmail(usuario);
    }

    /* (non-Javadoc)
	 * @see com.service.IUserService#getAll()
	 */
    public List<Usuario> getAll() {
        return userDAO.todos();
    }

    public void setUserDAO(IUserDao userDAO) {
        this.userDAO = userDAO;
    }
}
