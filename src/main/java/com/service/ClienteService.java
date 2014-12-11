package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.IClienteDao;
import com.model.Cliente;

@Transactional(readOnly = true)
public class ClienteService implements Serializable, IClienteService {


    private static final long serialVersionUID = 1L;

    public IClienteDao clienteDAO;
    
    public ClienteService () {
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#add(com.model.Cliente)
	 */
    @Transactional(readOnly = false)
    public void add(Cliente cliente) {
        clienteDAO.adicionar(cliente); 		// verifica se existe o ID cadastrado
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#isExiste(com.model.Cliente)
	 */
    public boolean isExiste(Cliente cliente) {
        //Verifica se existe usuario user.getNome()
        if (getByCpfCnpj(cliente) != null)
            return true;
        else
            return false;
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#recuperar(java.lang.Integer)
	 */
    public Cliente recuperar(Integer id) {
        return clienteDAO.recuperar(id);
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#delete(com.model.Cliente)
	 */
    @Transactional(readOnly = false)
    public void delete(Cliente cliente) {
        clienteDAO.deletar(cliente);
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#update(com.model.Cliente)
	 */
    @Transactional(readOnly = false)
    public void update(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#getById(com.model.Cliente)
	 */
    public Cliente getById(Cliente cliente) {
        return clienteDAO.recuperar(cliente);
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#getByCpfCnpj(com.model.Cliente)
	 */
    public Cliente getByCpfCnpj(Cliente cliente) {
        return clienteDAO.recuperarPorCpfCnpj(cliente);
    }

    /* (non-Javadoc)
	 * @see com.service.IClienteService#getAll()
	 */
    public List<Cliente> getAll() {
        return clienteDAO.todos();
    }

    public void setClienteDAO(IClienteDao clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
}
