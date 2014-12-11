package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IPerfilDao;
import com.model.Perfil;

@Transactional(readOnly = true)
public class PerfilService implements Serializable, IPerfilService {


    private static final long serialVersionUID = 1L;

    public IPerfilDao perfilDAO;
    
    public PerfilService () {
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#add(com.model.Perfil)
	 */
    @Transactional(readOnly = false)
    public void add(Perfil perfil) {
        perfilDAO.adicionar(perfil); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#isExiste(com.model.Perfil)
	 */
    public boolean isExiste(Perfil perfil) {
        //Verifica se existe usuario user.getNome()
        if (getByNome(perfil) != null)
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#recuperar(java.lang.Integer)
	 */
    public Perfil recuperar(Integer id) {
        return perfilDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#delete(com.model.Perfil)
	 */
    @Transactional(readOnly = false)
    public void delete(Perfil perfil) {
        perfilDAO.deletar(perfil);
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#update(com.model.Perfil)
	 */
    @Transactional(readOnly = false)
    public void update(Perfil perfil) {
        perfilDAO.atualizar(perfil);
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#getById(com.model.Perfil)
	 */
    public Perfil getById(Perfil perfil) {
        return perfilDAO.recuperar(perfil);
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#getByNome(com.model.Perfil)
	 */
    public Perfil getByNome(Perfil perfil) {
        return perfilDAO.recuperarPorNome(perfil);
    }

    /* (non-Javadoc)
	 * @see com.service.IPerfilService#getAll()
	 */
    public List<Perfil> getAll() {
        return perfilDAO.todos();
    }

    public void setPerfilDAO(IPerfilDao PerfilDAO) {
        this.perfilDAO = PerfilDAO;
    }
}
