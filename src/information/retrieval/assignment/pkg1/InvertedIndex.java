package information.retrieval.assignment.pkg1;

import java.util.ArrayList;

public class InvertedIndex {
    public ArrayList<Term> iIndex;
    
    public InvertedIndex ( ) {
        iIndex = new ArrayList<Term>();
    }
    
    public void insert ( String str, int documentNumber ) {
        Term object = new Term();
        object.set(str, documentNumber);
        iIndex.add(object);
    }
    
    public boolean contains ( String str ) {
        for ( int i=0; i<iIndex.size(); ++i ) {
            if ( iIndex.get(i).value.equals(str) ) return true;
        } return false;
    }
    
    public void increaseFrequency ( String str, int documentNumber ) {
        boolean found = false;
        for ( int i=0; !found && i<iIndex.size(); ++i ) {
            if ( iIndex.get(i).value.equals(str) ) {
                found = true;
                iIndex.get(i).documentFrequency++;
                iIndex.get(i).posting.add(documentNumber);
            }
        }
    }
}
