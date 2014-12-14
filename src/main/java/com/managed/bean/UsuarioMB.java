package com.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.model.Cliente;
import com.model.Usuario;
import com.service.IClienteService;
import com.service.IUsuarioService;
import com.util.Message;
import com.util.view.SelectOneDataModel;

public class UsuarioMB extends BaseMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

	private List<Usuario> userList;
	
	private SelectOneDataModel<Cliente> comboCliente;

    private IUsuarioService usuarioService;
    private IClienteService clienteService;

	public UsuarioMB(IUsuarioService usuarioService, IClienteService clienteService) {
		setUserService(usuarioService);
		setClienteService(clienteService);
		
		setComboCliente(new SelectOneDataModel<Cliente>(clienteService.getAll()));
		
		setUsuario(new Usuario());
        // montaPerfilList();
    }

    private String getDefaultPassword(String strCpf){
        //Senha default  composto pelos 5 primeiros numeros do CPF
        return strCpf.replace(".","").replace("-", "").substring(0, 5);
    }

    public void limpar(){
    	//falta 
    }
    
    public String novo() {
    	if (getUsuario() == null)
    		setUsuario(new Usuario());
    		return CRIAR;
    }
    
    public String salvar() {
	
    	//getUsuario().setCliente(getComboCliente().getObjetoSelecionado());
    	
        // se o usuario existir atualiza
        if (getUsuario().getId() != 0) {
            // selecaoToPerfilEnum(this.user);
            getUserService().update(getUsuario());
            return LISTAR;
            // valida se existe p/adicionar
        } else if (!getUserService().isExiste(getUsuario())) {

            if (getUsuario().getSenha() == null) {
                getUsuario().setSenha(getDefaultPassword(getUsuario().getEmail()));
            }

            // /selecaoToPerfilEnum(this.user);
            getUserService().add(getUsuario());
            return LISTAR;
        } else {
            Message.addMessage("cadastroUsuario.existente");
            return null;
        }
    }

    public String deletar(Usuario usuario) {
        getUserService().delete(usuario);
        return null;
    }

    public String atualizar(Usuario usuario) {
        getUserService().update(usuario);
        return CRIAR;
    }

    public String editar(Usuario usuario) {
        setUsuario(usuario);
        //getComboCliente().setSelecao(usuario.getCliente().getNome());
        return EDITAR;
    }

    public String listar() {
    	return LISTAR;
    }
    
    public String getLabelCadastro() {
        if (getUsuario().getId() == 0) {
            return Message.getBundleMessage("cadastroUsuario.label.titulo");
        } else {
            return Message
                    .getBundleMessage("cadastroUsuario.label.alteraUsuario");
        }
    }

    public void reset() {
        setUsuario(new Usuario());
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUserList() {
        this.userList = new ArrayList<Usuario>();
        this.userList.addAll(getUserService().getAll());
        return userList;
    }

    public void setUserList(List<Usuario> userList) {
		this.userList = userList;
	}
    
    public IUsuarioService getUserService() {
		return this.usuarioService;
	}
    
    public void setUserService(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public SelectOneDataModel<Cliente> getComboCliente() {
		return comboCliente;
	}

	public void setComboCliente(SelectOneDataModel<Cliente> comboCliente) {
		this.comboCliente = comboCliente;
	}

	public IClienteService getClienteService() {
		return this.clienteService;
	}
    
    public void setClienteService(IClienteService clienteService) {
        this.clienteService = clienteService;
    }
}
