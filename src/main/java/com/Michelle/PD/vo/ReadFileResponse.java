package com.Michelle.PD.vo;

import com.Michelle.PD.entity.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadFileResponse {
    
    private Map<String, Set<String>> synonyms;
    private List<List<Tuple>> tupleLists;
    
    public ReadFileResponse(Map<String, Set<String>> synonyms, List<List<Tuple>> tupleLists) {
        this.synonyms = synonyms;
        this.tupleLists = tupleLists;
    }
    
    public Map<String, Set<String>> getSynonyms() {
        return synonyms;
    }
    
    public void setSynonyms(Map<String, Set<String>> synonyms) {
        this.synonyms = synonyms;
    }
    
    public List<List<Tuple>> getTupleLists() {
        return tupleLists;
    }
    
    public void setTupleLists(List<List<Tuple>> tupleLists) {
        this.tupleLists = tupleLists;
    }
}
