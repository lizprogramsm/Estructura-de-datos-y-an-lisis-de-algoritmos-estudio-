package Listas_conceptos;

public class ListaCircular {
    Nodo Cabeza;
    public ListaCircular(){
        Cabeza=null;
    }
    //insertar en una lista circular
    public void insertar(int dato){
        Nodo nuevo=new Nodo(dato);
        if(Cabeza==null){
            Cabeza=nuevo;
            nuevo.siguiente=Cabeza;
        }else{
            Nodo actual = Cabeza;
            while (actual.siguiente != Cabeza) {


            }
        }
    }
}
