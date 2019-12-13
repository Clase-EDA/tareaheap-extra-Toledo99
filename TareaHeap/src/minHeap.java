/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tonotoledo
 */
public class minHeap <T extends Comparable<T>> implements minHeapADT<T>{
    private int cont;
    private NodoHeap[] arr;
    private int n;

    public minHeap() {
        cont =0;
        arr= new NodoHeap[4];
        n=4;
    }
    
    public minHeap(int max) {
        cont =0;
        arr=  new NodoHeap[max];
        n=max;
    }
    
    public void expande(){
        n=n*2;
        NodoHeap[] arr2=arr;
        arr=new NodoHeap[n];
        for(int i=0; i<arr2.length; i++){
            arr[i]=arr2[i];
        }
    }
    

    public void inserta(T elem, Comparable prioridad) {
        if(elem!=null){
            cont++;
            if(cont>=n){
                expande();
            }
            int aux=cont;
            NodoHeap<T> nuevo=new NodoHeap(elem, prioridad);
            arr[cont]=nuevo;
            boolean band=true;
            
            while(band && aux!=1){
                aux>>=1;
                if(arr[aux].getPrioridad().compareTo(prioridad)>0){
                    NodoHeap guardar=arr[aux];
                    arr[aux]=arr[cont];
                    arr[cont]=guardar;
                }
                else
                    band=false;
            }
        }
    }
    
    public NodoHeap<T> eliminaMin(){
        NodoHeap res=arr[1];
        
        if(res!=null){
            arr[1]=arr[cont];
            arr[cont]=null;
            cont--;

            boolean band=true;
            int act=1;
            int aux1=act<<1;
            int aux2=aux1+1;
            while(band && aux1<cont){
                int min;
                
                if(aux2<cont)
                    min=aux1;
                else{
                    if(arr[aux1].getPrioridad().compareTo(arr[aux2].getPrioridad())<0){
                        min=aux1;
                    }
                    else
                        min=aux2;  
                }
                if(arr[min].getPrioridad().compareTo(arr[act].getPrioridad())<0){
                    swap(min, act);
                    act=min;
                    aux1=act<<1;
                    aux2=aux1+1;
                }
                else
                    band=false;
            }
        }
        return res;
    }
    
    public void swap(int el1, int el2){
        NodoHeap guardar=arr[el1];
        arr[el1]=arr[el2];
        arr[el2]=guardar;
    }

    public NodoHeap getMin() {
        return arr[1];
    }
    
    private Integer min(Integer papa){
        Integer pos1 =papa<<1, pos2=pos1+1;
        Integer res=null;
        if(pos1<cont){
            if(pos2>cont)
                res = pos1;
            else{
                if(arr[pos1].getPrioridad().compareTo(arr[pos2].getPrioridad())<0)
                    res = pos1;
                else
                    res = pos2;
            }
        }
        return res;
    }
    
    public <T extends Comparable<T>> T[] heapSort() {
        T[] res = (T[]) (new Comparable[cont]);
        int i = 0;
        while (cont != 0) {
            Object elem = this.eliminaMin();
            if (elem != null) {
                res[i] = (T) elem;

                i++;
            }

        }
        return res;
    }
    
    public static void main(String[] args){
         minHeap heap=new minHeap();
         
         heap.inserta(5, 5);
         heap.inserta(2, 2);
         heap.inserta(10, 10);
         heap.inserta(9, 9);
         heap.inserta(3, 3);
         heap.inserta(11, 11);
         heap.eliminaMin();
         heap.eliminaMin();
         
         for(int i=1; i<=heap.cont; i++){
             System.out.println(heap.arr[i].getElem());
         }
         
    }
    
    
    
}
