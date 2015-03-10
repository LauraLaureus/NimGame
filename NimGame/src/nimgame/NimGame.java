
package nimgame;

import Gamers.IANimPlayer;
import Gamers.RealNimPlayer;

public class NimGame {

    /*
        NimGame
    Reglas:
        el primer jugador tiene que coger almenos 1 y puede coger tantos como quiera
        pero tiene que dejar almenos una para el jugador contrario.
    
        el siguiente tiene que coger como mínimo 1 palillo y como máximo el doble
        de los que cogió el jugador anterior.
    
        Gana el que se queda con el último palillo.
    */
    
    public static void main(String[] args) {
        
        int pieces = 5;
        //TODO for future versions 
        /*
        Hacer una interfaz para que el número de palillos los ponga el jugador
        al inicio de la partida.
        */
        
        IANimPlayer ia = new IANimPlayer(pieces);
        RealNimPlayer real = new RealNimPlayer();
        
        while(pieces > 0){
            pieces = ia.play(pieces);
            if(pieces == 0){
                System.out.println("La inteligencia artificial ha ganado");
                break;
            }
            
            pieces = real.play(pieces);
            if(pieces == 0){
                System.out.println("El jugador ha ganado");
                break;
            }
        }
    }
    
}
