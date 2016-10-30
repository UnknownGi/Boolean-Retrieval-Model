package guiBooleanModel;

import java.util.ArrayList;

public class QueryHandler {
    public ArrayList<Integer> processBoolean ( String query, InvertedIndex ii, ArrayList<String> collection ) {
        String[] array = query.split(" ");
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if ( array.length > 0 ) {
            int start = 2;
            
            if ( "NOT".equals(array[0]) ) {
                list = ii.dictionary.get(array[1]);
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for ( int i=1; i<collection.size(); ++i ) {
                    if ( !list.contains(i) ) temp.add(i);
                }
                
                list = temp;
                start = 3;
            }
            else list = ii.dictionary.get(array[0]);
            
            for ( int i=2; i<array.length; i+=2 ) {
                if ( "AND".equals(array[i-1]) ) {
                    if ( !("NOT".equals(array[i])) ) {
                        if ( ii.dictionary.containsKey(array[i]) ) list.retainAll(ii.dictionary.get(array[i]));
                        else return (new ArrayList<Integer>());
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        for ( int j=0; j<collection.size(); ++j ) tmp.add(j+1);
                        if ( ii.dictionary.containsKey(array[i+1]) ) {
                            tmp.removeAll(ii.dictionary.get(array[i+1]));
                            list.retainAll(tmp);
                            i = i+1;
                        }
                    }
                } else if ( "OR".equals(array[i-1]) ) {
                    if ( !("NOT".equals(array[i])) ) {
                        if ( ii.dictionary.containsKey(array[i]) ) list.addAll(ii.dictionary.get(array[i]));
                    } else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        for ( int j=0; j<collection.size(); ++j ) tmp.add(j+1);
                        if ( ii.dictionary.containsKey(array[i+1]) ) {
                            tmp.removeAll(ii.dictionary.get(array[i+1]));
                            list.addAll(tmp);
                            i = i+1;
                        }
                    } 
                }
            }
        }
        
        removeDuplicate(list);
        return list;
    }
    
    public ArrayList<Integer> processProximity ( String query, PositionalIndex pi, ArrayList<String> collection ) {
        String[] array = query.split(" ");
        
        pTerm list = new pTerm();
        if ( array.length > 0 ) {
            int start = 2;
            
            if ( "NOT".equals(array[0]) ) {
                list = pi.dictionary.get(array[1]);
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for ( int i=1; i<collection.size(); ++i ) {
                    if ( !list.documentNumber.contains(i) ) temp.add(i);
                }
                
                list.documentNumber = temp;
                start = 3;
            }
            else list = pi.dictionary.get(array[0]);
            
            for ( int i=start; i<array.length; i+=2 ) {
                if ( "AND".equals(array[i-1]) ) {
                    if ( !("NOT".equals(array[i])) ) {
                        if ( pi.dictionary.containsKey(array[i]) ) list.documentNumber.retainAll(pi.dictionary.get(array[i]).documentNumber);
                        else return (new ArrayList<Integer>());
                    } else {
                        pTerm tmp = new pTerm();
                        for ( int j=0; j<collection.size(); ++j ) tmp.documentNumber.add(j+1);
                        if ( pi.dictionary.containsKey(array[i+1]) ) {
                            tmp.documentNumber.removeAll(pi.dictionary.get(array[i+1]).documentNumber);
                            list.documentNumber.retainAll(tmp.documentNumber);
                            i = i+1;
                        }
                    }
                } 
            }
        }
        
        
    }
    
    public ArrayList<Integer> processPhrase ( String query, InvertedIndex ii, ArrayList<String> collection ) {
        String[] array = query.split(" ");
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if ( array.length > 0 ) {
            list = ii.dictionary.get(array[0]);
            if ( array.length > 1 ) {
                for ( int i=1; i<array.length; ++i ) {
                    if ( ii.dictionary.containsKey(array[i]) ) list.retainAll(ii.dictionary.get(array[i]));
                    else return (new ArrayList<Integer>());
                }
            }
        }
        
        ArrayList<Integer> phraseList = new ArrayList<Integer>();
        if ( list != null ) {
            for ( int i=0; i<list.size(); ++i ) {
                if ( collection.get(list.get(i)-1).contains(query) ) phraseList.add(list.get(i));
            }
        }
        
        return phraseList;
    }
    
    private ArrayList<Integer> removeDuplicate ( ArrayList<Integer> list ) {
        ArrayList<Integer> unique = new ArrayList<Integer>();
        for ( int i=0; i<list.size(); ++i ) {
            if ( !unique.contains(list.get(i)) ) unique.add(list.get(i));
        }
        
        return unique;
    }
    public void printList ( ArrayList<Integer> list ) {
        if ( list != null ) {
            for ( int i=0; i<list.size(); ++i ) System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }
}
