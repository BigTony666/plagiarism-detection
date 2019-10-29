package com.Michelle.PD.PlagiarismDetector;

import com.Michelle.PD.File.SynonymsFile;
import com.Michelle.PD.File.TupleFile;
import com.Michelle.PD.entity.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class defines the plagiarism detector
 */
public class PlagiarismDetector implements IPlagiarismDetector {
    
    @Override
    public Double detect(TupleFile tupleFile1, TupleFile tupleFile2, SynonymsFile synonymsFile) {
        long count = 0L;
        Map<String, Set<String>> synonyms = synonymsFile.getSynonyms();
        List<Tuple> tuples1 = tupleFile1.getTuples();
        List<Tuple> tuples2 = tupleFile2.getTuples();
        
        for (Tuple t1 : tuples1) {
            for (Tuple t2 : tuples2) {
                if (Tuple.isMatch(synonyms, t1, t2)) count++;
            }
        }
        
        return 1.0 * count / tupleFile1.getSize();
    }
}
