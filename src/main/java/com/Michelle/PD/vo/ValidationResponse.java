package com.Michelle.PD.vo;

public class ValidationResponse {
    
    private Double plagiarismRatio;
    
    public ValidationResponse(Double plagiarismRatio) {
        this.plagiarismRatio = plagiarismRatio;
    }
    
    public Double getPlagiarismRatio() {
        return plagiarismRatio;
    }
    
    public void setPlagiarismRatio(Double plagiarismRatio) {
        this.plagiarismRatio = plagiarismRatio;
    }
}
