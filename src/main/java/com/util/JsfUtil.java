package com.util;

import javax.faces.context.FacesContext;

public class JsfUtil {

    public static void setSessionValue(String key, Object value){
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put(key, value);
    }

    public static void removeFromSession(String key){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .remove(key);
    }

}
