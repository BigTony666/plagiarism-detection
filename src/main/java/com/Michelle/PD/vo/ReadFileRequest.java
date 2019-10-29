package com.Michelle.PD.vo;

public class ReadFileRequest {
    
    private String synonymsFilePath;
    private String inputFilePath1;
    private String inputFilePath2;
    private int N;
    
    public ReadFileRequest(String synonymsFilePath, String inputFilePath1, String inputFilePath2, int n) {
        this.synonymsFilePath = synonymsFilePath;
        this.inputFilePath1 = inputFilePath1;
        this.inputFilePath2 = inputFilePath2;
        N = n;
    }
    
    public String getSynonymsFilePath() {
        return synonymsFilePath;
    }
    
    public void setSynonymsFilePath(String synonymsFilePath) {
        this.synonymsFilePath = synonymsFilePath;
    }
    
    public String getInputFilePath1() {
        return inputFilePath1;
    }
    
    public void setInputFilePath1(String inputFilePath1) {
        this.inputFilePath1 = inputFilePath1;
    }
    
    public String getInputFilePath2() {
        return inputFilePath2;
    }
    
    public void setInputFilePath2(String inputFilePath2) {
        this.inputFilePath2 = inputFilePath2;
    }
    
    public int getN() {
        return N;
    }
    
    public void setN(int n) {
        N = n;
    }
}
