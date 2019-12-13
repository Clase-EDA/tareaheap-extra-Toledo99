/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tonotoledo
 */
public interface minHeapADT <T extends Comparable<T>> {
    public void inserta(T elem, Comparable prioridad);
    public NodoHeap getMin();
    public NodoHeap eliminaMin();
}
