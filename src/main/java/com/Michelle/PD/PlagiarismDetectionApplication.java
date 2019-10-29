package com.Michelle.PD;

import com.Michelle.PD.File.SynonymsFile;
import com.Michelle.PD.File.TupleFile;
import com.Michelle.PD.PlagiarismDetector.PlagiarismDetector;
import com.Michelle.PD.utils.ArgumentParser;
import com.Michelle.PD.utils.Logger;

public class PlagiarismDetectionApplication {
    
    public static void main(String[] args) {
        
        Logger logger = Logger.INSTANCE.getInstance();
        
        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.parse(args);
        TupleFile tupleFile1 = argumentParser.getTupleFile1();
        TupleFile tupleFile2 = argumentParser.getTupleFile2();
        SynonymsFile synonymsFile = argumentParser.getSynonymsFile();
        
        PlagiarismDetector plagiarismDetector = new PlagiarismDetector();
        double plagiarismRatio = plagiarismDetector.detect(tupleFile1, tupleFile2, synonymsFile);
        
        logger.info("Plagiarism Percentage is " + plagiarismRatio * 100 + " %");
    }
}
