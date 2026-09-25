package Listas_conceptos;

public class ListaSimple {//estructura de datos lineal
    Nodo Cabeza;

    public ListaSimple(){
        Cabeza=null;
    }
    //para insertar un dato al inicio
    public void InsertarInicio(int dato){
        //insertar al inicio es igual a una complejidad O (1) constante
        Nodo nuevo=new Nodo(dato);
        nuevo.siguiente=Cabeza;//siguiente es el puntero
        Cabeza=nuevo;//el nuevo dato pasa a ser la nueva cabeza o dato ingresado
    }

    //insertar al final
    public void InsettarFinal(int dato){
        Nodo nuevo=new Nodo(dato);
        if(Cabeza==null){
            Cabeza=nuevo;
        }else{
            Nodo actual= Cabeza;
            while (actual.siguiente !=null){
                actual =actual.siguiente;
            }
            actual.siguiente=nuevo;
        }
    }
    //para recorrer la lista SIMPLE
    public void recorrer(){//void metodo que realiza una tarea pero no regresa un valor (recordatorio sintaxis basica)
        Nodo actual=Cabeza;
        while(actual !=null){
            System.out.println(actual.dato+"->");
            actual=actual.siguiente;
        }
        System.out.println("null");
    }

    //Buscar en la lista SIMPLE
    public boolean buscar(int valor){
        Nodo actual= Cabeza;

        while(actual !=null){
            if(actual.dato==valor){
                return true;// si el dato es igual al valor ingresado se regresa verdadero
            }
            actual=actual.siguiente;
        }
        return false;
    }
    //eliminar de la lista Simple
    public void eliminar(int valor){
        Nodo actual=Cabeza;
        Nodo anterior=null;

        while(actual!=null){
            if(actual.dato==valor){
                Cabeza=actual.siguiente;
            }else{
                anterior.siguiente=actual.siguiente;
            }
            return;
        }
        anterior=actual;
        actual=actual.siguiente;
    }

}
