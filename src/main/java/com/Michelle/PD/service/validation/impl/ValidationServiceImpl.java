package com.Michelle.PD.service.validation.impl;

import com.Michelle.PD.entity.Tuple;
import com.Michelle.PD.service.validation.IValidationService;
import com.Michelle.PD.vo.ValidationRequest;
import com.Michelle.PD.vo.ValidationResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationServiceImpl implements IValidationService {
    
    public ValidationResponse getPlagiarismRatio(ValidationRequest request) {
        Map<String, Set<String>> synonyms = request.getSynonyms();
        List<Tuple> tupleList1 = request.getTupleLists().get(0);
        List<Tuple> tupleList2 = request.getTupleLists().get(1);
        long count = 0L;
        
        if (!tupleList1.isEmpty() && !tupleList2.isEmpty()) {
            for (Tuple t1 : tupleList1) {
                for (Tuple t2 : tupleList2) {
                    if (Tuple.isMatch(synonyms, t1, t2)) count++;
                }
            }
        }
        
        return new ValidationResponse(1.0 * count / tupleList1.size());
    }
}
