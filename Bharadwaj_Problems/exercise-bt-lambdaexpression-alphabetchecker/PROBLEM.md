## Problem Statement: Check whether given list of strings contains only alphabets or not ##

**Given a list of strings, check whether each string in list contains only alphabets or not using lambda expressions**

**This exercise contains a class named AlphabetChecker with the following method:**


    +checkAlphabets(List<String>) : String
        -Should accept list of strings as input
        -Should return "Give proper input not empty list" if given list is empty
        -Should check whether given list of strings contains all alphabets as charcters or not using lambda expressions
        -Should return "Given list contains only alphabet strings" if list contains only alphabet strings
        -Should return "Given list contains non alphabet strings" if list contains non alphabet strings        
      
## Example
    Sample Input:
    [Java,code]
    
    Expected Output:   
    Given list contains only alphabet strings
--------------------------------------------------------
    Sample Input:
    [Java!!,Code**]
      
    Expected Output:
    Given list contains non alphabet strings
--------------------------------------------------------
    Sample Input:
    []
    Expected Output:
    Give proper input not empty list


## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding