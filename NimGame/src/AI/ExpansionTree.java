package AI;

import java.util.Map;

public class ExpansionTree {
    /*
    SRP: generate tree for AI computation in the state space.
    */
    
    private final HeuristicComponent deterministic;
    private final HeuristicComponent estimation;
    
    private ComputableState current;

    public ExpansionTree(HeuristicComponent deterministic, HeuristicComponent estimation, ComputableState current) {
        this.deterministic = deterministic;
        this.estimation = estimation;
        this.current = current;
    }
    
    public ComputableState getNextMovement(){
        return getBestOf(current.expand());
    }
    
    public void computeAdversayMovement(ComputableState adversaryMovement){
        this.current = adversaryMovement;
    }

    private ComputableState getBestOf(Map<ComputableState, Float> expand) {
        Float cmp = Float.MAX_VALUE;
        ComputableState result = null;
        
        for (Map.Entry<ComputableState,Float> heuristic : expand.entrySet()) {
            if(heuristic.getValue() < cmp){
                cmp = heuristic.getValue();
                result = heuristic.getKey();
            }
        }
        
        return result;
    }
}
