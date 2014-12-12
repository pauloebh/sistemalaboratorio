package com.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IFuncaoDao;
import com.model.Funcao;
import com.service.IFuncaoService;

@Transactional(readOnly = true)
public class FuncaoService implements Serializable, IFuncaoService {


    private static final long serialVersionUID = 1L;

    public IFuncaoDao funcaoDAO;
    
    public FuncaoService () {
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#add(com.model.Funcao)
	 */
    @Transactional(readOnly = false)
    public void add(Funcao Funcao) {
        funcaoDAO.adicionar(Funcao); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#isExiste(com.model.Funcao)
	 */
    public boolean isExiste(Funcao Funcao) {
        //Verifica se existe Funcao Funcao.getNome()
        if (getByNome(Funcao) != null )
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#recuperar(java.lang.Integer)
	 */
    public Funcao recuperar(Integer id) {
        return funcaoDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#delete(com.model.Funcao)
	 */
    @Transactional(readOnly = false)
    public void delete(Funcao Funcao) {
        funcaoDAO.deletar(Funcao);
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#update(com.model.Funcao)
	 */
    @Transactional(readOnly = false)
    public void update(Funcao Funcao) {
        funcaoDAO.atualizar(Funcao);
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#getById(com.model.Funcao)
	 */
    public Funcao getById(Funcao Funcao) {
        return funcaoDAO.recuperar(Funcao);
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#getByNome(com.model.Funcao)
	 */
    public Funcao getByNome(Funcao Funcao) {
        return funcaoDAO.recuperarPorNome(Funcao);
    }

    /* (non-Javadoc)
	 * @see com.service.IFuncaoService#getAll()
	 */
    public List<Funcao> getAll() {
        return funcaoDAO.todos();
    }

    public void setFuncaoDAO(IFuncaoDao FuncaoDAO) {
        this.funcaoDAO = FuncaoDAO;
    }
}
