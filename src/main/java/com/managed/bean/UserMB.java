package com.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.model.Cliente;
import com.model.Usuario;
import com.service.IClienteService;
import com.service.IUserService;
import com.util.Message;

public class UserMB extends BaseMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    
    private List<SelectItem> funcaoList;
	private List<Usuario> userList;
	private List<Cliente> clienteList;

    private IUserService userService;
    private IClienteService clienteService;

	public UserMB(IUserService userService, IClienteService clienteService) {
		setUserService(userService);
		setClienteService(clienteService);
		
		setUser(new Usuario());
        // montaPerfilList();
    }

    private String getDefaultPassword(String strCpf){
        //Senha default  composto pelos 5 primeiros numeros do CPF
        return strCpf.replace(".","").replace("-", "").substring(0, 5);
    }

    public void limpar(){
    	//falta 
    }
    
    public String newUser() {
    	if (getUser() == null)
    		setUser(new Usuario());
    		return CRIAR;
    }
    
    public String addUser() {
	
        // se o usuario existir atualiza
        if (getUser().getId() != 0) {
            // selecaoToPerfilEnum(this.user);
            getUserService().update(getUser());
            return LISTAR;
            // valida se existe p/adicionar
        } else if (!getUserService().isExiste(getUser())) {

            if (getUser().getSenha() == null) {
                getUser().setSenha(getDefaultPassword(getUser().getCpf()));
            }

            // /selecaoToPerfilEnum(this.user);
            getUserService().add(getUser());
            return LISTAR;
        } else {
            Message.addMessage("cadastroUsuario.existente");
            return null;
        }
    }

    public String deleteUser(Usuario usuario) {
        getUserService().delete(usuario);
        return null;
    }

    public String updateUser(Usuario usuario) {
        getUserService().update(usuario);
        return CRIAR;
    }

    public String editUser(Usuario usuario) {
        setUser(usuario);
        return EDITAR;
    }

    public String listaUsuarios() {
    	return LISTAR;
    }
    
    public String getLabelCadastro() {
        if (getUser().getId() == 0) {
            return Message.getBundleMessage("cadastroUsuario.label.titulo");
        } else {
            return Message
                    .getBundleMessage("cadastroUsuario.label.alteraUsuario");
        }
    }

    public void reset() {
        setUser(new Usuario());
    }
    
    public Usuario getUser() {
        return this.usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Cliente> getClientes() {
        this.clienteList = new ArrayList<Cliente>();
        this.clienteList.addAll(getClienteService().getAll());
        return clienteList;
    }

    public List<Usuario> getUserList() {
        this.userList = new ArrayList<Usuario>();
        this.userList.addAll(getUserService().getAll());
        return userList;
    }

    public void setUserList(List<Usuario> userList) {
		this.userList = userList;
	}
    
    public IUserService getUserService() {
		return this.userService;
	}
    
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    
    public IClienteService getClienteService() {
		return this.clienteService;
	}
    
    public void setClienteService(IClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    public List<SelectItem> getFuncaoList() {
		return funcaoList;
	}

	public void setFuncaoList(List<SelectItem> funcaoList) {
		this.funcaoList = funcaoList;
	}
}
