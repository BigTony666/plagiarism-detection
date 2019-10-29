package com.Michelle.PD;

import com.Michelle.PD.entity.Tuple;
import com.Michelle.PD.service.readFile.IReadFile;
import com.Michelle.PD.service.readFile.impl.ReadFileImpl;
import com.Michelle.PD.service.validation.IValidationService;
import com.Michelle.PD.service.validation.impl.ValidationServiceImpl;
import com.Michelle.PD.utils.ArgumentsChecker;
import com.Michelle.PD.utils.Logger;
import com.Michelle.PD.vo.ReadFileRequest;
import com.Michelle.PD.vo.ReadFileResponse;
import com.Michelle.PD.vo.ValidationRequest;
import com.Michelle.PD.vo.ValidationResponse;

public class PlagiarismDetectionApplication {
    
    public static void main(String[] args) {
        Logger logger = Logger.INSTANCE.getInstance();
        
        if (!ArgumentsChecker.isValidArguments(args)) {
            logger.error("Invalid Arguments");
            System.exit(1);
        }
        
        // Step 1: get the ReadFileRequest
        ReadFileRequest readFileRequest = ArgumentsChecker.parseArguments(args);
        Tuple.setN(readFileRequest.getN());
        try {
            // Step 2: read the file
            IReadFile fileReader = new ReadFileImpl();
            ReadFileResponse readFileResponse = fileReader.readFile(readFileRequest);
    
            // Step 3: get the validation result
            ValidationRequest validationRequest = new ValidationRequest(readFileResponse.getSynonyms(), readFileResponse.getTupleLists());
            IValidationService validator = new ValidationServiceImpl();
            ValidationResponse validationResponse = validator.getPlagiarismRatio(validationRequest);
            double plagiarismRatio = validationResponse.getPlagiarismRatio();
            logger.info("Plagiarism Percentage is " + plagiarismRatio * 100 + " %");
        } catch (Exception e) {
            logger.error("Invalid File Path");
            System.exit(1);
        }
    }
}
