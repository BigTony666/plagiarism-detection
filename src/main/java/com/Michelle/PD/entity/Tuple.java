package com.Michelle.PD.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class defines the Tuple
 * A Tuple entity has a list of words and a sizeOfTuple field
 */
public class Tuple {
    
    private List<String> words;
    private static int sizeOfTuple;
    
    public Tuple(List<String> words) {
        this.words = words;
    }
    
    public List<String> getWords() {
        return words;
    }
    
    public void setWords(List<String> words) {
        this.words = words;
    }
    
    public static int getSizeOfTuple() {
        return sizeOfTuple;
    }
    
    public static void setSizeOfTuple(int sizeOfTuple) {
        Tuple.sizeOfTuple = sizeOfTuple;
    }
    
    public static boolean isMatch(Map<String, Set<String>> synonyms, Tuple tuple1, Tuple tuple2) {
        List<String> words1 = tuple1.getWords();
        List<String> words2 = tuple2.getWords();
        
        if (words1.size() != words2.size()) return false;
        
        for (int i = 0; i < Tuple.sizeOfTuple; i++) {
            String word1 = words1.get(i);
            String word2 = words2.get(i);
            
            if (!word1.equals(word2)) {
                Set<String> synonymSet = synonyms.get(word1);
                
                if (synonymSet == null || !synonymSet.contains(word2)) return false;
            }
        }
        return true;
    }
}
