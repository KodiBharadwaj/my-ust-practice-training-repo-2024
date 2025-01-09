## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**


- Below is the summary of the solution provided

- This exercise contains a Generic class named LambdaExpressionsDemo  with the following methods :

           +arithmeticOperation(List<Integer> integers, int dividend)
                -Should perform a division operation on the dividend by the list of divisors and return a list of quotients.The 
                most important thing is to throw exception when there is a division by zero.This exception is handled in ThrowngCustoMConsumer 
                functional interface.
           +writeToFile(int offset, List<String> namesList)
               -Should write the file Strings contained in the list to the file and name the file with the .txt and must return a list of files.The 
               most important thing is to throw exception when file operations fail.This exception is handled in ThrowngCustoMConsumer 
               functional interface.
               
- Create class LambdaExpressionsDemoTests in package com.stackroute.lambdaexpressions 
 
    - write the unit tests for testing set,find,remove the eldest element for Integer and String type elements
- Some of the test cases are mentioned below

    - arithmeticOperation method called with list of Integer values  and a dividend    
    - arithmeticOperation method called with list of Integer values containing zero and a dividend    
    - arithmeticOperation method called with empty list and a dividend
    - arithmeticOperation method called with null values   
    - writeToFile method called with list of String values and 0 offset     
    - writeToFile method called with list of String values and offset = 10
    - writeToFile method called with empty list and an offset
    - writeToFile method called with null values
    
 Note:Any other specific types can be tested as the class is Generic type.But currently the code is tested with <Integer,Integer> ,<String,String>    

- Minimum test cases expected : 8


- Test cases should be written for positive, negative and boundary scenarios, wherever applicable


- Test coverage should be 100%



## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding

## Code coverage 

 - Run mvn test, the JaCoCo code coverage report will be generated at target/site/jacoco/*
 - Open the target/site/jacoco/index.html file, review the code coverage report 
 
            - Green – Code is tested or covered.
            - Red – Code is not tested or covered.
            - Yellow – Code is partially tested or covered.
 - Make sure lines coverage must meet the minimum 90%