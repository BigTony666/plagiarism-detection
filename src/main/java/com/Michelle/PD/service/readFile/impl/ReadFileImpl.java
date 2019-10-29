package com.Michelle.PD.service.readFile.impl;

import com.Michelle.PD.entity.Tuple;
import com.Michelle.PD.service.readFile.IReadFile;
import com.Michelle.PD.vo.ReadFileRequest;
import com.Michelle.PD.vo.ReadFileResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileImpl implements IReadFile {
    
    public ReadFileResponse readFile(ReadFileRequest readFileRequest) throws IOException {
        String synonymsFilePath = readFileRequest.getSynonymsFilePath();
        String inputFilePath1 = readFileRequest.getInputFilePath1();
        String inputFilePath2 = readFileRequest.getInputFilePath2();
        
        // Step 1: get synonyms
        Map<String, Set<String>> synonyms = generateSynonyms(synonymsFilePath);
        
        List<List<Tuple>> tuplesList = new ArrayList<>();
        // Step 2: get input1
        tuplesList.add(generateTuples(inputFilePath1));
        
        // Step 3: get input2
        tuplesList.add(generateTuples(inputFilePath2));
        
        // Step 4: generate response
        return new ReadFileResponse(synonyms, tuplesList);
    }
    
    private Map<String, Set<String>> generateSynonyms(String synonymsFilePath) throws IOException {
        Map<String, Set<String>> synonyms = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(synonymsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                Set<String> wordSet = new HashSet<>(Arrays.asList(words));
                
                for (String word : words) {
                    synonyms.putIfAbsent(word, wordSet);
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid Synonyms File Path");
            System.exit(1);
        }
        
        return synonyms;
    }
    
    private List<Tuple> generateTuples(String inputFilePath1) throws IOException {
        List<Tuple> tuples = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath1))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Step 1: extract words out of a line
                List<String> words = extractWords(line);
                
                // Step 2: generate tuples
                tuples.addAll(buildTuples(words));
            }
        } catch (Exception e) {
            System.err.println("Invalid Input File Path");
            System.exit(1);
        }
        
        return tuples;
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
    
        if (words.size() < Tuple.N) return tuples;
        
        for (int i = 0; i <= words.size() - Tuple.N; i++) {
            List<String> wordsInTuple = new ArrayList<>();
            
            for (int j = i; j < i + Tuple.N; j++) {
                wordsInTuple.add(words.get(j));
            }
            
            tuples.add(new Tuple(wordsInTuple));
        }
        return tuples;
    }
}
