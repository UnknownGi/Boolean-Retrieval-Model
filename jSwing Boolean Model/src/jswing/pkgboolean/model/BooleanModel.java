package jswing.pkgboolean.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BooleanModel {
    public ArrayList<String> fetchDocuments ( ) throws FileNotFoundException {
        File file = new File("dataset/Quran Translation.txt");
        Scanner sc = new Scanner(file);
        
        String str = "";
        Tokenizer t = new Tokenizer();
        ArrayList<String> collection = new ArrayList<String>();
        while ( sc.hasNext() ) {
            String temp = sc.nextLine();
            
            if ( temp.charAt(0) == '[' ) {
                if ( str.length() > 0 ) {
                    // System.out.println(str);
                    collection.add(str);
                    str = "";
                }
                
                str = str + temp + ' ';
            } else {
                temp = t.tokenize(temp);
                // temp = t.removeStopword(temp, stopword);
                str = str + temp + ' ';
            }
        }
        
        System.out.println(collection.size());
        return collection;
    } 
    
    public ArrayList<String> fetchStopword ( ) throws FileNotFoundException {
        File file = new File("dataset/Stopword-List.txt");
        Scanner sc = new Scanner(file);
        
        ArrayList<String> list = new ArrayList<String>();
        while ( sc.hasNext() ) list.add(sc.nextLine());
        
        return list;
    }
}
