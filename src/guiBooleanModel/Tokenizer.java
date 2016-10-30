package guiBooleanModel;

import java.util.ArrayList;

public class Tokenizer {
    public String tokenize ( String str ) {
        str = str.toLowerCase();
        
        String toReturn = "";
        String[] array = str.split(" ");
        for ( int i=0; i<array.length; ++i ) 
            toReturn = toReturn + removeSpecial(array[i]) + ' ';
        
        return toReturn;
    }
    
    public String removeStopword ( String str, ArrayList<String> stopword ) {
        String toReturn = "";
        String[] array = str.split(" ");
        
        for ( int i=0; i<array.length; ++i ) {
            if ( !(stopword.contains(array[i])) ) toReturn = toReturn + array[i] + ' ';
        }
        
        return toReturn;
    }
    
    private String removeSpecial ( String str ) {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
}
