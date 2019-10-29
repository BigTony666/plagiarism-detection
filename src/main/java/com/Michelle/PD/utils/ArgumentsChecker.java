package com.Michelle.PD.utils;

import com.Michelle.PD.entity.Tuple;
import com.Michelle.PD.vo.ReadFileRequest;

public class ArgumentsChecker {
    
    private static final int NUM_ARGS_LIMITED = 4;
    
    public static boolean isValidArguments(String[] args) {
        int n = args.length;
        return n >= NUM_ARGS_LIMITED - 1 && n <= NUM_ARGS_LIMITED && (n != 4 || CommonUtils.isInteger(args[3]));
    }
    
    public static ReadFileRequest parseArguments(String[] args) {
        int n = args.length;
        
        String synonymsFilePath = args[0];
        String inputFilePath1 = args[1];
        String inputFilePath2 = args[2];
        int N = (n == 4) ? Integer.parseInt(args[3]) : 3;
        
        return new ReadFileRequest(synonymsFilePath, inputFilePath1, inputFilePath2, N);
    }
}
