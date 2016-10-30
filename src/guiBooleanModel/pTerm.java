package guiBooleanModel;

import java.util.ArrayList;

public class pTerm {
    public int documentFrequency = 0;
    public ArrayList<Integer> documentNumber;
    public ArrayList<ArrayList<Integer>> documentPosition;
    
    public pTerm ( ) {
        documentNumber = new ArrayList<Integer>();
        documentPosition = new ArrayList<ArrayList<Integer>>();
    }
}
