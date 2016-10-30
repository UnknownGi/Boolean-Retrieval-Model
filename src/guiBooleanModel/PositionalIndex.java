package guiBooleanModel;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PositionalIndex {
    public Map<String, pTerm> dictionary = new HashMap<String, pTerm>();
    
    public PositionalIndex constructIndex ( BooleanModel bm, ArrayList<String> collection, Tokenizer t ) throws FileNotFoundException {
        ArrayList<String> stopword = bm.fetchStopword();
                        
        for ( int i=0; i<collection.size(); ++i ) {
            String temp = t.removeStopword(collection.get(i), stopword);
            String[] array = temp.split(" ");
                            
            for ( int j=1; j<array.length; ++j ) {
                if ( !(this.dictionary.containsKey(array[j])) ) {
                    pTerm term = new pTerm();
                    term.documentFrequency++;
                    term.documentNumber.add(i+1);
                    
                    term.documentPosition.add(new ArrayList<Integer>());
                    term.documentPosition.get(0).add(j+1);
                    
                    this.dictionary.put(array[j], term);
                } else {
                    pTerm term = this.dictionary.get(array[j]);
                    term.documentFrequency++;
                    
                    if ( term.documentNumber.contains(i+1) ) {
                        boolean found = false;
                        for ( int k=0; !found && k<term.documentNumber.size(); ++k ) {
                            if ( term.documentNumber.get(k) == i+1 ) {
                                found = true;
                                term.documentPosition.get(k).add(j+1);
                                this.dictionary.put(array[j], term);
                            }
                        }
                    } else {
                        term.documentNumber.add(i+1);
                    
                        term.documentPosition.add(new ArrayList<Integer>());
                        term.documentPosition.get(term.documentPosition.size()-1).add(j+1);
                        
                        this.dictionary.put(array[j], term);
                    }
                }
            }
        }
        
        Map<String, pTerm> map = new TreeMap<String, pTerm>(dictionary);
        dictionary = map;
        
        return this;
    }
    
    public void printIndex ( ) {
        for ( Map.Entry<String, pTerm> entry : dictionary.entrySet() ) {
            System.out.println("<" + entry.getKey() + ", " + entry.getValue().documentFrequency);
            for ( int i=0; i<entry.getValue().documentNumber.size(); ++i ) {
                System.out.print("D" + entry.getValue().documentNumber.get(i) + ": ");
                for ( int j=0; j<entry.getValue().documentPosition.get(i).size(); ++j ) System.out.print(entry.getValue().documentPosition.get(i).get(j) + " ");
                System.out.println();
            }
            System.out.println(">");
        }
    }
    
    public void writeIndexToFile ( ) throws IOException {
        File file = new File("dataset/Positional-Index.txt");
        
        if ( !file.exists() ) 
            file.createNewFile();
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        int k=0;
        for ( Map.Entry<String, pTerm> entry : dictionary.entrySet() ) {
            if ( k>=1 ) {
                bw.write("<" + entry.getKey() + ", " + entry.getValue().documentFrequency);
                bw.newLine();
                for ( int i=0; i<entry.getValue().documentNumber.size(); ++i ) {
                    bw.write("D" + entry.getValue().documentNumber.get(i) + ": ");
                    for ( int j=0; j<entry.getValue().documentPosition.get(i).size(); ++j ) bw.write(entry.getValue().documentPosition.get(i).get(j) + " ");
                    bw.newLine();
                }
                   
                bw.write(">"); bw.newLine();
            } else ++k;
        }
        
        bw.flush();
        bw.close();
    }
    
    public void OpenFile ( ) throws IOException {
        File file = new File("dataset/Positional-Index.txt");
        
        if ( Desktop.isDesktopSupported() ) {
            Desktop.getDesktop().edit(file);
        }
    }
}
