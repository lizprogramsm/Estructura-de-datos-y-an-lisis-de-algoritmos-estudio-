package EjerciciosPilasColas;

import java.util.ArrayDeque;
import java.util.Queue;


public class RoundRobin {

        public static int[] roundRobin (int[] rafagas, int quantum){
            int n =  rafagas.length;
            int[] restante = rafagas.clone();
            int[] fin = new int [n];

           Queue<Integer> listos=new ArrayDeque<>();

           for(int i =0; i<n ; i++) listos.add(i);

           int reloj =0;
           while(!listos.isEmpty()){
           int i=listos.poll();
           int uso= Math.min(quantum, restante[i]);
           reloj += uso;
           restante[i] -= uso;

          if(restante[i] > 0){
               listos.add(i);
          }else{

             fin[i]=reloj;
          }
      }
        return fin;
    }
}