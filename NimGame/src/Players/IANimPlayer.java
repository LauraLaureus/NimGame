
package Players;

import AI.*;

public class IANimPlayer implements Player{

    private HeuristicComponent deterministic;
    private HeuristicComponent estimation;
    private final ExpansionTree tree;
    
    
    public IANimPlayer(final int pieces) {
        this.deterministic = new HeuristicComponent() {

            private int reference = pieces;
            @Override
            public float compute(ComputableState state) {
                return reference - state.getPiecesleft();
            }
        };
        
        this.estimation = new HeuristicComponent() {

            @Override
            public float compute(ComputableState state) {
                return state.getUpperbound() / state.getPiecesleft();
            }
        };
        
        this.tree = new ExpansionTree(deterministic, estimation,
                new ComputableState(pieces, pieces-1, deterministic, estimation));
    }

    @Override
    public ComputableState move() {
        return this.tree.getNextMovement();
    }

    @Override
    public void getAdversaryMove(ComputableState adversary) {
        this.tree.computeAdversayMovement(adversary);
    }

    
}
