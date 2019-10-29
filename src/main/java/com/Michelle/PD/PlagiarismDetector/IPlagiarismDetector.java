package com.Michelle.PD.PlagiarismDetector;

import com.Michelle.PD.File.SynonymsFile;
import com.Michelle.PD.File.TupleFile;

public interface IPlagiarismDetector {
    
    Double detect(TupleFile inputFile1, TupleFile inputFile2, SynonymsFile synonymsFile);
}
