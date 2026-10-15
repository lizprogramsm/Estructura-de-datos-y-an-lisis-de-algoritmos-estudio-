package Matriz_ortogonal;

public class Principal {
    public static void main(String [] args){
        MatrizOrtogonal matriz = new MatrizOrtogonal(4, 4);
        matriz.insertar(0,2,1);
        matriz.insertar(2,1,8);
        matriz.insertar(1,1,5);

        matriz.mostrarPorFilas();
        matriz.mostrarPorColumnas();
        matriz.mostrarMatrizCompleta();
        matriz.eliminar(2,1);
        matriz.transpones();


    }
}
