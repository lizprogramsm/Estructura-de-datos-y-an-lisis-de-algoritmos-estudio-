package Matriz_ortogonal;

public class MatrizOrtogonal {
    private NodoOrtogonal[] filas;
    private NodoOrtogonal[] columnas;
    private int numFilas;
    private int numColumnas;

    public MatrizOrtogonal(int numFilas, int numColumnas){
        this.numFilas= numFilas;
        this.numColumnas= numColumnas;
        filas = new NodoOrtogonal[numFilas];
        columnas = new NodoOrtogonal[numColumnas];
    }

    public void insertar(int fila, int columna, int valor){
        if(fila<0 || fila>= numFilas || columna<0 || columna >= numColumnas){
            System.out.println("Posicion fuera de rango.");
            return;
        }
        if(valor == 0){
            System.out.println("No se insertan ceros en una matriz dispersa.");
            return;
        }

        NodoOrtogonal nuevo =new NodoOrtogonal(fila, columna, valor);
        insertarEnFila(nuevo);
        insertarEnColumna(nuevo);
    }
    private void insertarEnFila(NodoOrtogonal nuevo){
        int fila = nuevo.fila;
        if(filas[fila]==null || nuevo.columna < filas[fila].columna){
            nuevo.derecha= filas[fila];
            filas[fila]= nuevo;
            return;
        }
        NodoOrtogonal actual= filas[fila];
        while(actual.derecha !=null && actual.derecha.columna < nuevo.columna){
            actual= actual.derecha;
        }
        if( actual.derecha !=null && actual.derecha.columna == nuevo.columna){
            actual.derecha.valor= nuevo.valor;
            return;
        }
        nuevo.derecha =actual.derecha;
        actual.derecha= nuevo;
    }

    private void insertarEnColumna(NodoOrtogonal nuevo){
        int columna = nuevo.columna;
        if(columnas[columna]==null || nuevo.fila < columnas[columna].fila){
            nuevo.abajo = columnas[columna];
            columnas[columna]= nuevo;
            return;
        }
        NodoOrtogonal actual= columnas[columna];
        while( actual.abajo != null && actual.abajo.fila < nuevo.fila){
            actual = actual.abajo;
        }
        if(actual.abajo != null && actual.abajo.fila == nuevo.fila){
            actual.abajo.valor= nuevo.valor;
            return;
        }
        nuevo.abajo =actual.abajo;
        actual.abajo = nuevo;
    }

    public void mostrarPorFilas() {
        System.out.println("Recorrido por filas:");
        for (int i = 0; i < numFilas; i++) {
            System.out.print("Fila " + i + ": ");
            NodoOrtogonal actual = filas[i];
            while (actual != null) {
                System.out.print("(" + actual.fila + "," + actual.columna + "," + actual.valor + ") ");
                actual = actual.derecha;
            }
            System.out.println();
        }
    }

    public void mostrarPorColumnas() {
        System.out.println("Recorrido por columnas:");
        for (int j = 0; j < numColumnas; j++) {
            System.out.print("Columna " + j + ": ");
            NodoOrtogonal actual = columnas[j];
            while (actual != null) {
                System.out.print("(" + actual.fila + "," + actual.columna + "," + actual.valor + ") ");
                actual = actual.abajo;
            }
            System.out.println();
        }
    }

    public void mostrarMatrizCompleta() {
        System.out.println("Matriz completa:");
        for (int i = 0; i < numFilas; i++) {
            NodoOrtogonal actual = filas[i];
            for (int j = 0; j < numColumnas; j++) {
                if (actual != null && actual.columna == j) {
                    System.out.print(actual.valor + "\t");
                    actual = actual.derecha;
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }


    public int buscar (int fila, int columna){
        if(fila<0 || fila>= numFilas || columna <0 || columna >= numColumnas) return 0;
        NodoOrtogonal actual = filas[fila];
        while(actual != null){
            if(actual.columna == columna) return actual.valor;
            actual= actual.derecha;
        }
        return 0;
    }

    public void eliminar(int fila, int columna){
        if( fila <0 || fila >= numFilas || columna< 0 || columna >= numColumnas){
            System.out.println("Posicion fuera de rango.");
            return;
        }
        NodoOrtogonal objetivo=null;
        NodoOrtogonal anteriorFila=null;
        NodoOrtogonal actual=filas[fila];

        while(actual != null && actual.columna != columna){
            anteriorFila = actual;
            actual=actual.derecha;
        }
        if(actual == null){
            System.out.println(" No existe un valor en ("+ fila +","+ columna+")");
        }
        objetivo=actual;

        if(anteriorFila == null){
            filas[fila]= objetivo.derecha;
        }else{
            anteriorFila.derecha = objetivo.derecha;
        }

        NodoOrtogonal anteriorColumna =null;
        NodoOrtogonal cursorColumna = columnas[columna];

        while(cursorColumna != objetivo){
            anteriorColumna = cursorColumna;
            cursorColumna= cursorColumna.abajo;
        }
        if(anteriorColumna == null){
            columnas[columna] = objetivo.abajo;
        }else{
            anteriorColumna.abajo= objetivo.abajo;
        }
     }

     public void transpones(){
        NodoOrtogonal [] temp=filas;
        filas=columnas;
        columnas=temp;

        int tempN =numFilas;
        numFilas = numColumnas;
        numColumnas= tempN;

        for(NodoOrtogonal cabeza : filas){
            NodoOrtogonal actual= cabeza;
            while(actual != null){
                int f= actual.fila;
                actual.fila = actual.columna;
                actual.columna = f;

                NodoOrtogonal d = actual.derecha;
                actual.derecha = actual.abajo;
                actual.abajo = d;

                actual = actual.derecha;
            }
        }
     }
}
