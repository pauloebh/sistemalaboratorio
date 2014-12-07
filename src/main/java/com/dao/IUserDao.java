package com.dao;

import com.model.User;

import java.util.List;

public interface IUserDao extends AbstractDao<User> {
 
    public User recuperar(User user);
    public User recuperarPorCpf(User user);
    public User recuperarPorEmail(User user);
    public Boolean buscaPorLogin(User user);
    List<User> todos();
}
