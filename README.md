# Plagiarism Detection Program

## Design

The program is to detect the plagiarism ratio of two input files with the synonyms file. The comparison algorithm
is by N-Tuple.

## Architecture

The PlagiarismDetector class, which contains the business logic of detecting the plagiarism ratio.

The ArgumentParser class helps to validate and parse the arguments, and generate TupleFile and SynonymsFile.

The SynonymsFile class encapsulates the synonyms content.

The TupleFile class encapsulates the input files content.

The Tuple class defines the N-size tuple unit, the N-Tuple comparison algorithm is based on this entity.

The Logger class defines the logger to log out error and message.

The CommonUtils class defines some utility methods.

## Error Handling

IOException

## Usage

```sh
java -jar PlagiarismDetection.jar synonyms input1 input2 <4>
```