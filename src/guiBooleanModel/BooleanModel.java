package guiBooleanModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BooleanModel {
    public ArrayList<String> fetchDocuments ( ) throws FileNotFoundException {
        ArrayList<String> collection = new ArrayList<String>(); 
        
        collection = fetchFromFile(new File("dataset/Quran Translation.txt"));
        collection.addAll(fetchFromFile(new File("dataset/1")));
        collection.addAll(fetchFromFile(new File("dataset/2")));
        collection.addAll(fetchFromFile(new File("dataset/3")));
        collection.addAll(fetchFromFile(new File("dataset/4")));
        collection.addAll(fetchFromFile(new File("dataset/5")));
        collection.addAll(fetchFromFile(new File("dataset/6")));
        collection.addAll(fetchFromFile(new File("dataset/7")));
        collection.addAll(fetchFromFile(new File("dataset/8")));
        collection.addAll(fetchFromFile(new File("dataset/9")));
        collection.addAll(fetchFromFile(new File("dataset/10")));
        collection.addAll(fetchFromFile(new File("dataset/11")));
        collection.addAll(fetchFromFile(new File("dataset/12")));
        collection.addAll(fetchFromFile(new File("dataset/13")));
        collection.addAll(fetchFromFile(new File("dataset/14")));
        collection.addAll(fetchFromFile(new File("dataset/15")));
        
        return collection;
    } 
    
    private ArrayList<String> fetchFromFile ( File file ) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        
        String str = "";
        Tokenizer t = new Tokenizer();
        ArrayList<String> collection = new ArrayList<String>();
        while ( sc.hasNext() ) {
            String temp = sc.nextLine();
            
            if ( temp.charAt(0) == '[' ) {
                if ( str.length() > 0 ) {
                    collection.add(str);
                    str = "";
                }
                
                str = str + temp + ' ';
            } else {
                temp = t.tokenize(temp);
                str = str + temp + ' ';
            }
        }
        
        return collection;
    }
    
    public ArrayList<String> fetchStopword ( ) throws FileNotFoundException {
        File file = new File("dataset/Stopword-List.txt");
        Scanner sc = new Scanner(file);
        
        ArrayList<String> list = new ArrayList<String>();
        while ( sc.hasNext() ) list.add(sc.nextLine());
        
        return list;
    }
    
    public ArrayList<String> fetchQuery ( ) throws FileNotFoundException { 
        File file = new File("dataset/QueryList.txt");
        Scanner sc = new Scanner(file);
        
        ArrayList<String> list = new ArrayList<String>();
        while ( sc.hasNext() ) list.add(sc.nextLine());
        
        return list;
    }
}
