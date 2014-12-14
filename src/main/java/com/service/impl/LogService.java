package com.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ILogDao;
import com.model.Log;
import com.service.ILogService;

@Transactional(readOnly = true)
public class LogService implements Serializable, ILogService {


    private static final long serialVersionUID = 1L;

    public ILogDao logDAO;
    
    public LogService () {
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#add(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#add(com.model.Log)
	 */
    @Transactional(readOnly = false)
    public void add(Log Log) {
        logDAO.adicionar(Log); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#isExiste(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#isExiste(com.model.Log)
	 */
    public boolean isExiste(Log Log) {
        //Verifica se existe usuario user.getNome()
        if ( getById(Log) != null)
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#recuperar(java.lang.Integer)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#recuperar(java.lang.Integer)
	 */
    public Log recuperar(Integer id) {
        return logDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#delete(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#delete(com.model.Log)
	 */
    @Transactional(readOnly = false)
    public void delete(Log Log) {
        logDAO.deletar(Log);
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#update(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#update(com.model.Log)
	 */
    @Transactional(readOnly = false)
    public void update(Log Log) {
        logDAO.atualizar(Log);
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#getById(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#getById(com.model.Log)
	 */
    public Log getById(Log Log) {
        return logDAO.recuperar(Log);
    }

    /* (non-Javadoc)
	 * @see com.service.ILogService#getByNome(com.model.Log)
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#getByUsuario(com.model.Log)
	 */
    /*public List<Log> getByUsuario(Log Log) {
        return logDAO.recuperarPorUsuario(Log);
    }*/

    /* (non-Javadoc)
	 * @see com.service.ILogService#getAll()
	 */
    /* (non-Javadoc)
	 * @see com.service.impl.ILogService#getAll()
	 */
    public List<Log> getAll() {
        return logDAO.todos();
    }

    public void setLogDAO(ILogDao LogDAO) {
        this.logDAO = LogDAO;
    }
}
