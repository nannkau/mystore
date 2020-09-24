package com.team.mystore.Command;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractCommand<E> implements Serializable {
    private List<E> listResutl;
    private Map<String,E> mapResutl;
    protected E pojo;

    /**
     * @return the pojo
     */
    public E getPojo() {
        return pojo;
    }

    /**
     * @param pojo
     *            the pojo to set
     */
    public void setPojo(E pojo) {
        this.pojo = pojo;
    }

    public List<E> getListResutl() {
        return listResutl;
    }

    public void setListResutl(List<E> listResutl) {
        this.listResutl = listResutl;
    }

    public Map<String, E> getMapResutl() {
        return mapResutl;
    }

    public void setMapResutl(Map<String, E> mapResutl) {
        this.mapResutl = mapResutl;
    }
}
