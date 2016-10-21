package information.retrieval.assignment.pkg1;

import java.util.ArrayList;

public class Tokenizer {
    public ArrayList<String> tokenize ( String str, ArrayList<String> stopword ) {
        str = str.toLowerCase();
        String[] terms = str.split(" ");
        
        ArrayList<String> termList = new ArrayList<String>();
        for ( int i=0; i<terms.length; ++i ) {
            boolean found = false;
            for ( int j=0; !found && j<stopword.size(); ++j ) {
                if ( terms[i].equals(stopword.get(j)) ) found = true;
            }
            
            if ( !found ) termList.add(removeSpecial(terms[i]));
        }
        
        return termList;
    }
    
    public String removeSpecial ( String str ) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
}
