package com.Michelle.PD.File;

import com.Michelle.PD.entity.Tuple;
import com.Michelle.PD.utils.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class defines the tuple file
 */
public class TupleFile implements IFile {
    
    private List<Tuple> tuples;
    private int size;
    
    public List<Tuple> getTuples() {
        return tuples;
    }
    
    public void setTuples(List<Tuple> tuples) {
        this.tuples = tuples;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public void readFile(String filePath) {
        tuples = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Step 1: extract words out of a line
                List<String> words = extractWords(line);
                
                // Step 2: generate tuple file
                tuples.addAll(buildTuples(words));
            }
        } catch (Exception e) {
            Logger.INSTANCE.getInstance().error("Invalid Input File Path");
            System.exit(1);
        }
        
        size = tuples.size();
    }
    
    private List<String> extractWords(String line) {
        List<String> words = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(line);
        
        while (matcher.find()) {
            words.add(matcher.group());
        }
        
        return words;
    }
    
    private List<Tuple> buildTuples(List<String> words) {
        List<Tuple> tuples = new ArrayList<>();
        
        if (words.size() < Tuple.getSizeOfTuple()) return tuples;
        
        for (int i = 0; i <= words.size() - Tuple.getSizeOfTuple(); i++) {
            List<String> wordsInTuple = new ArrayList<>();
            
            for (int j = i; j < i + Tuple.getSizeOfTuple(); j++) {
                wordsInTuple.add(words.get(j));
            }
            
            tuples.add(new Tuple(wordsInTuple));
        }
        return tuples;
    }
}
