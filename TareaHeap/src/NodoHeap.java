/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tonotoledo
 */
public class NodoHeap <T extends Comparable<T>>  {
    private T elem;
    private Comparable prioridad;

    public NodoHeap(T elem, Comparable prioridad) {
        this.elem = elem;
        this.prioridad = prioridad;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public Comparable getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Comparable prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
}
