package EjerciciosPilasColas;

import java.util.ArrayDeque;
import java.util.Deque;


public class LimitadorDeTasa {

    private final int maxPeticiones;
    private final long  ventanaMs;
    private final Deque<Long> marcas = new ArrayDeque<>();

    private LimitadorDeTasa (int maxPeticiones, long ventanaMs){
        this.maxPeticiones = maxPeticiones;
        this.ventanaMs = ventanaMs;
    }

    public synchronized boolean permitir (long ahoraMs){

        while (! marcas.isEmpty() && ahoraMs - marcas.peekFirst() >= ventanaMs){
            marcas.pollFirst();
        }

        if(marcas.size() > maxPeticiones){
            marcas.addLast(ahoraMs);
            return true;
        }
        return false;
    }


}
