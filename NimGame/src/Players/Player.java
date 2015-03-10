

package Players;

import AI.ComputableState;

public interface Player {

    public ComputableState move();
    public void getAdversaryMove(ComputableState adversary);
    
}
