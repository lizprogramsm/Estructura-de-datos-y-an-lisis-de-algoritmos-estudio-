package ColasFIFO.Nodo_string;

public class ColaString {
    private Nodo_string frente;
    private Nodo_string fin;

    public ColaString(){
        frente=null;
        fin=null;
    }

    public void encolar(String dato){
        Nodo_string nuevo =new Nodo_string(dato);
        if(fin==null){
            frente = null;
            fin =null;
        }else{
            fin.siguiente=nuevo;
            fin=nuevo;
        }
    }
    public String desencolar(){
        if(frente==null){
            return "cola vacia.";
        }
        String dato =frente.dato;
        frente=frente.siguiente;
        if(frente == null){
            fin=null;
        }
        return dato;
    }
    public String verFrente(){
        if(frente==null){
            return "cola vacia.";
        }
        return frente.dato;
    }
    public boolean estaVacia (){
        return frente==null;
    }
    public int contar(){
        int contador=0;
        Nodo_string actual=frente;
        while (actual!=null){
            contador++;
            actual=actual.siguiente;
        }
        return contador;
    }
    public void mostrar() {
         Nodo_string actual = frente;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

}
