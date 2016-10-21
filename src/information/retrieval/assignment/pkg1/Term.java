package information.retrieval.assignment.pkg1;

import java.util.ArrayList;

public class Term {
    public String value;
    public int documentFrequency;
    public ArrayList<Integer> posting;
    
    public Term ( ) {
        documentFrequency = 0;
        posting = new ArrayList<Integer>();
    }
    
    public Term ( String t ) {
        value = t;
        documentFrequency = 1;
        posting = new ArrayList<Integer>();
    }
    
    public void set ( String str, int documentNumber ) {
        this.value = str;
        this.posting.add(documentNumber);
    }
}
