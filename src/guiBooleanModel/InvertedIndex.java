package guiBooleanModel;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class InvertedIndex {
    public Map<String, ArrayList<Integer>> dictionary;
    
    public InvertedIndex ( ) {
        dictionary = new HashMap<String, ArrayList<Integer>>();
    }
    
    public InvertedIndex constructIndex ( BooleanModel bm, ArrayList<String> collection, Tokenizer t ) throws FileNotFoundException {
        ArrayList<String> stopword = bm.fetchStopword();
                        
        for ( int i=0; i<collection.size(); ++i ) {
            String temp = t.removeStopword(collection.get(i), stopword);
            String[] array = temp.split(" ");
            
            for ( int j=1; j<array.length; ++j ) {
                if ( !(this.dictionary.containsKey(array[j])) ) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i+1);
                                    
                    this.dictionary.put(array[j], list);
                } else {
                    ArrayList<Integer> list = this.dictionary.get(array[j]);
                    list.add(i+1);
                                    
                    this.dictionary.put(array[j], list);
                }
            }
        }
        
        this.sortAndRemoveDuplicateHash();
        return this;
    }
    
    private ArrayList<Integer> removeDuplicate ( ArrayList<Integer> posting ) {
        ArrayList<Integer> removeDuplicate = new ArrayList<Integer>();
        for ( int i=0; i<posting.size(); ++i ) {
            if( !removeDuplicate.contains(posting.get(i)) ) removeDuplicate.add(posting.get(i));
        }
        
        return removeDuplicate;
    }
    
    private void sortAndRemoveDuplicateHash ( ) {
        for ( Map.Entry<String, ArrayList<Integer>> entry : dictionary.entrySet() ) {
            entry.setValue(removeDuplicate(entry.getValue()));
            Collections.sort(entry.getValue());
        }
        
        Map<String, ArrayList<Integer>> map = new TreeMap<String, ArrayList<Integer>>(dictionary);
        dictionary = map;
    }
    
    public void printIndex ( ) {
        for ( Map.Entry<String, ArrayList<Integer>> entry : dictionary.entrySet() ) {
            System.out.print(entry.getKey() + " " + entry.getValue().size() + " -> ");
            for ( int i=0; i<entry.getValue().size(); ++i ) System.out.print(entry.getValue().get(i) + " ");
            System.out.println();
        }
    }
    
    public void writeIndexToFile ( ) throws IOException {
        File file = new File("dataset/Inverted-Index.txt");
        
        if ( !file.exists() ) 
            file.createNewFile();
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        int j=0;
        for ( Map.Entry<String, ArrayList<Integer>> entry : dictionary.entrySet() ) {
            if ( j>=1 ) {
                bw.write(entry.getKey() + " " + entry.getValue().size() + " -> ");
                for ( int i=0; i<entry.getValue().size(); ++i ) bw.write(entry.getValue().get(i) + " ");
                bw.newLine();
            } else ++j;
        }
        
        bw.flush();
        bw.close();
    }
    
    public void OpenFile ( ) throws IOException {
        File file = new File("dataset/Inverted-Index.txt");
        
        if ( Desktop.isDesktopSupported() ) {
            Desktop.getDesktop().edit(file);
        }
    }
}
