
package Gamers;

public class IANimGamer implements Gamer{

    private int pieces;

    public IANimGamer(int pieces) {
        this.pieces = pieces;
    }

    @Override
    public int play(int currentGamePieces) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
