package AI;

import java.util.HashMap;
import java.util.Map;

public class ComputableState {

    private final int piecesleft;
    private final int upperbound;
    
    private final HeuristicComponent deterministic;
    private final HeuristicComponent estimation;

    public ComputableState(int piecesleft, int upperbound, HeuristicComponent deterministic, HeuristicComponent estimation) {
        this.piecesleft = piecesleft;
        this.upperbound = upperbound;
        this.deterministic = deterministic;
        this.estimation = estimation;
    }

    public int getPiecesleft() {
        return piecesleft;
    }

    public int getUpperbound() {
        return upperbound;
    }
    
    
    
    
    public Map<ComputableState,Float> expand(){
        HashMap<ComputableState,Float> result = new HashMap<>();
        ComputableState son;
        for(int i = 1; i <= upperbound; i++){
            son = new ComputableState(piecesleft-i,upperbound-i,this.deterministic, this.estimation);
            result.put(son,deterministic.compute(son)+ estimation.compute(son));
        }
        return result;
    }
}
