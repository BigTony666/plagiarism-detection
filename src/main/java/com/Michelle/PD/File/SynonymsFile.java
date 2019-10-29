package com.Michelle.PD.File;

import com.Michelle.PD.utils.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * This class defines the synonyms file
 */
public class SynonymsFile implements IFile {
    
    private Map<String, Set<String>> synonyms;
    
    public Map<String, Set<String>> getSynonyms() {
        return synonyms;
    }
    
    public void setSynonyms(Map<String, Set<String>> synonyms) {
        this.synonyms = synonyms;
    }
    
    @Override
    public void readFile(String filePath) {
        synonyms = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                Set<String> wordSet = new HashSet<>(Arrays.asList(words));
                
                for (String word : words) {
                    synonyms.putIfAbsent(word, wordSet);
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.getInstance().error("Invalid Synonyms File Path");
            System.exit(1);
        }
    }
}
