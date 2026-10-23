package ColasFIFO;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String []args){
        Queue <String> cola=new LinkedList<>();
        cola.add("A");
        cola.add("B");
        cola.add("C");
        System.out.println("cola:  "+cola);//mostrar
        System.out.println("primera: "+cola.peek());//peek
        System.out.println("Atendido: "+cola.poll());// dequeue
        System.out.println("tamaño: "+cola.size());
        System.out.println("¿vacio?: "+cola.isEmpty());
    }
}
