package com.dao;

import java.util.List;

import com.model.Log;

public interface ILogDao extends InterfaceDao<Log> {
 
    public Log recuperar(Log Log);
    public List <Log> recuperarPorUsuario(Log Log);
    public List<Log> todos();
}
