package com.Michelle.PD.service.validation;

import com.Michelle.PD.vo.ValidationRequest;
import com.Michelle.PD.vo.ValidationResponse;

public interface IValidationService {
    
    ValidationResponse getPlagiarismRatio(ValidationRequest request);
}
