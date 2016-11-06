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
            
            for ( int i=start; i<array.length; i+=2 ) {
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
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if ( array.length > 0 ) {
            String regex = "(.*)" + array[0];
            for ( int i=2; i<array.length; i+=2 ) {
                String positional = array[i+1];
                positional = positional.substring(1);

                for ( int j=1; j<Integer.parseInt(positional); ++j ) regex += "\\s(\\S+)";
                
                regex += "\\s";
                regex += array[i];
                regex += "(.*)";
                
                ++i;
            }
            
            for ( int i=0; i<collection.size(); ++i ) {
                if ( collection.get(i).matches(regex) ) result.add(i+1);
            }
            
            solve(collection, result, regex, 0);
        }
        
        return result;
    }
    
    private void solve ( ArrayList<String> collection, ArrayList<Integer> result, String regex, int iterator ) {
        String newRegex = regex;
        int index = newRegex.indexOf("(\\S+)");
        
        if ( index != -1 ) {
            String afterChange = newRegex.substring(0, index)+newRegex.substring(index+5, newRegex.length());
            
            if ( afterChange.contains("\\s\\s") ) {
                int in = afterChange.indexOf("\\s\\s");
                
                afterChange = afterChange.substring(0, in)+afterChange.substring(in+2, afterChange.length());
            }
            
            for ( int i=0; i<collection.size(); ++i ) {
                if ( collection.get(i).matches(afterChange) ) result.add(i+1);
            }
            
            solve(collection, result, afterChange, iterator+1);
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
