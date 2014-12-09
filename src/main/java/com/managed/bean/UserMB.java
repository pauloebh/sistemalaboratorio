package com.managed.bean;

import com.model.User;
import com.service.IUserService;
import com.util.Message;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userController")
@RequestScoped
public class UserMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "cadUser";
    private static final String EDIT = "editUsuer";

    private User user;
    
    private List<SelectItem> funcaoList;
	private List<User> userList;

	@ManagedProperty(value = "#{UserService}")
    private IUserService userService;

	public UserMB(IUserService userService) {
		setUserService(userService);
		setUser(new User());
        // montaPerfilList();
    }

    private String getDefaultPassword(String strCpf){
        //Senha default  composto pelos 5 primeiros numeros do CPF
        return strCpf.replace(".","").replace("-", "").substring(0, 5);
    }


    public String addUser() {


        // se o usuario existir atualiza
        if (getUser().getUserId() != 0) {
            // selecaoToPerfilEnum(this.user);
            getUserService().updateUser(getUser());
            return SUCCESS;
            // valida se existe p/adicionar
        } else if (!getUserService().isExiteUser(getUser())) {

            if (getUser().getSenha() == null) {
                getUser().setSenha(getDefaultPassword(getUser().getCpf()));
            }

            // /selecaoToPerfilEnum(this.user);
            getUserService().addUser(getUser());
            return SUCCESS;
        } else {
            Message.addMessage("cadastroUsuario.existente");
            return null;
        }
    }

    public String deleteUser(User user) {
        getUserService().deleteUser(user);
        return null;
    }

    public String updateUser(User user) {
        getUserService().updateUser(user);
        return SUCCESS;
    }

    public String editUser(User user) {
        setUser(user);
        return EDIT;
    }

    public String getLabelCadastro() {
        if (getUser().getUserId() == 0) {
            return Message.getBundleMessage("cadastroUsuario.label.titulo");
        } else {
            return Message
                    .getBundleMessage("cadastroUsuario.label.alteraUsuario");
        }
    }

    public void reset() {
        setUser(new User());
    }
    
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        this.userList = new ArrayList<User>();
        this.userList.addAll(getUserService().getUsers());
        return userList;
    }

    public void setUserList(List<User> userList) {
		this.userList = userList;
	}
    
    public IUserService getUserService() {
		return this.userService;
	}
    
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    
    public List<SelectItem> getFuncaoList() {
		return funcaoList;
	}

	public void setFuncaoList(List<SelectItem> funcaoList) {
		this.funcaoList = funcaoList;
	}
}
