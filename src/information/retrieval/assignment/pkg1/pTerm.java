package information.retrieval.assignment.pkg1;

import java.util.ArrayList;

public class pTerm {
    public String term;
    public int documentFrequency;
    public ArrayList<Integer> documentList;
    public ArrayList<ArrayList<Integer>> documentPosition;
    
    public pTerm ( String s ) {
        term = s;
        documentFrequency = 1;
        documentList = new ArrayList<Integer>();
        documentPosition = new ArrayList<ArrayList<Integer>>();
    }
}
