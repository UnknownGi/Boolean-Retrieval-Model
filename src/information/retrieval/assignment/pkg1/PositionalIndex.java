package information.retrieval.assignment.pkg1;

import java.util.ArrayList;

public class PositionalIndex {
    public ArrayList<pTerm> pIndex;
    
    PositionalIndex ( ) {
        pIndex = new ArrayList<pTerm>();
    }
    
    void insert ( pTerm t ) {
        pIndex.add(t);
    }
    
    void insert ( String str, int docNo, int docPos ) {
        pTerm pt = new pTerm(str);
        pIndex.add(pt);
        pIndex.get(pIndex.size()-1).documentList.add(docNo);
        pIndex.get(pIndex.size()-1).documentPosition.add(new ArrayList<Integer>());
        pIndex.get(pIndex.size()-1).documentPosition.get(0).add(docPos);
    }
    
    void update ( String str, int docNo, int docPos ) {
        int in = containPos(str);
        
        pIndex.get(in).documentFrequency++;
        
        boolean found = false;
        for ( int i=0; !false && i<pIndex.get(in).documentList.size(); ++i ) {
            if ( pIndex.get(in).documentList.get(i) == docNo ) {
                found = true;
                pIndex.get(in).documentPosition.get(i).add(docPos);
            }
        }
        
        if ( !found ) {
            pIndex.get(in).documentList.add(docNo);
            pIndex.get(in).documentPosition.add(new ArrayList<Integer>());
            pIndex.get(in).documentPosition.get(pIndex.get(in).documentPosition.size()-1).add(docPos);
        }
    }
    
    boolean contains ( String str ) {
        for ( int i=0; i<pIndex.size(); ++i ) {
            if ( pIndex.get(i).term.equals(str) ) return true;
        } return false;
    }
    
    int containPos ( String str ) {
        for ( int i=0; i<pIndex.size(); ++i ) {
            if ( pIndex.get(i).term.equals(str) ) return i;
        } return -1;
    }
}
