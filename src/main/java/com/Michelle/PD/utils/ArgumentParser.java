package com.Michelle.PD.utils;

import com.Michelle.PD.File.SynonymsFile;
import com.Michelle.PD.File.TupleFile;
import com.Michelle.PD.entity.Tuple;

/**
 * This class defines the argument parser that helps to parse the arguments,
 * and generate synonyms file and tuple files
 */
public class ArgumentParser {
    
    private static final int NUM_ARGS_LIMITED = 4;
    private static String synonymsFilePath;
    private static String tupleFilePath1;
    private static String tupleFilePath2;
    private static int sizeOfTuple;
    
    public static boolean isValidArguments(String[] args) {
        int n = args.length;
        return n >= NUM_ARGS_LIMITED - 1 && n <= NUM_ARGS_LIMITED && (n != 4 || CommonUtils.isInteger(args[3]));
    }
    
    public void parse(String[] args) {
        if (!isValidArguments(args)) {
            Logger.INSTANCE.getInstance().error("Invalid Arguments");
            System.exit(1);
        }
        
        int n = args.length;
        
        synonymsFilePath = args[0];
        tupleFilePath1 = args[1];
        tupleFilePath2 = args[2];
        sizeOfTuple = (n == 4) ? Integer.parseInt(args[3]) : 3;
        Tuple.setSizeOfTuple(sizeOfTuple);
    }
    
    public TupleFile getTupleFile1() {
        TupleFile tupleFile = new TupleFile();
        tupleFile.readFile(tupleFilePath1);
        return tupleFile;
    }
    
    public TupleFile getTupleFile2() {
        TupleFile tupleFile = new TupleFile();
        tupleFile.readFile(tupleFilePath2);
        return tupleFile;
    }
    
    public SynonymsFile getSynonymsFile() {
        SynonymsFile synonymsFile = new SynonymsFile();
        synonymsFile.readFile(synonymsFilePath);
        return synonymsFile;
    }
}
