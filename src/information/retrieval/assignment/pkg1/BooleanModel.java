package information.retrieval.assignment.pkg1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BooleanModel {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /* Reading Stopwords from Stopword-List.txt */
        File stopwrd = new File("dataset/Stopword-List.txt");
        Scanner stopsc = new Scanner(stopwrd);
        
        ArrayList<String> stopword = new ArrayList<String>();
        
        while ( stopsc.hasNext() ) {
            String stop_word = stopsc.nextLine();
            stopword.add(stop_word);
        }
        
        /* Reading Corpus to extract documents */
        File file = new File("dataset/Quran Translation.txt");
        Scanner sc = new Scanner(file);
        
        ArrayList<String> collection = new ArrayList<String>();
        
        while ( sc.hasNext() ) {
            String document = sc.nextLine();
            if ( document.charAt(0)!='[' ) collection.add(document);
        }
        
        /* Creating a Inverted Index */
        InvertedIndex index = new InvertedIndex();
        PositionalIndex pIndex = new PositionalIndex();
        for ( int i=0; i<collection.size(); ++i ) {
            Tokenizer t = new Tokenizer();
            ArrayList<String> token = t.tokenize(collection.get(i), stopword);
            
            for ( int j=0; j<token.size(); ++j ) {
                if ( !(index.contains(token.get(j))) ) 
                    index.insert(token.get(j), i+1);
                else index.increaseFrequency(token.get(j), i+1);
                
                if ( !(pIndex.contains(token.get(j))) ) 
                    pIndex.insert(token.get(j), i+1, j+1);
                else pIndex.update(token.get(j), i+1, j+1);
            }
        }
        
        /* Writing Inverted Index to File */
        file = new File("dataset/Inverted-Index.txt");

        if ( !file.exists() ) 
            file.createNewFile();

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        System.out.println(index.iIndex.size());
        for ( int i=0; i<index.iIndex.size(); ++i ) {
            bw.write(index.iIndex.get(i).value + " " + index.iIndex.get(i).documentFrequency + " -> ");
            for ( int j=0; j<index.iIndex.get(i).posting.size(); ++j ) bw.write(index.iIndex.get(i).posting.get(j) + " ");
            bw.newLine();
        }
        
        /* Writing Positional Index to File */
        file = new File("dataset/Positional-Index.txt");
        
        if ( !file.exists() ) 
            file.createNewFile();
        
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
        
        System.out.println(pIndex.pIndex.size());
        for ( int i=0; i<pIndex.pIndex.size(); ++i ) {
            bw.write("<" + pIndex.pIndex.get(i).term + ", " + pIndex.pIndex.get(i).documentFrequency); bw.newLine();
            for ( int j=0; j<pIndex.pIndex.get(i).documentList.size(); ++j ) {
                bw.write("D" + pIndex.pIndex.get(i).documentList.get(j) + ": ");
                
                for ( int k=0; k<pIndex.pIndex.get(i).documentPosition.get(j).size(); ++k ) bw.write(pIndex.pIndex.get(i).documentPosition.get(j).get(k) + " ");
                bw.newLine();
            } bw.write(">"); bw.newLine();
        } bw.write(">"); bw.newLine();
    } // #EndOfPublicStaticMain!   
} // #EndOfIRAssignment#1!
