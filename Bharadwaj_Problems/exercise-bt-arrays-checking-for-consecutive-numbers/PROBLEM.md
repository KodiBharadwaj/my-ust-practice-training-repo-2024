## Problem Statement: Check whether given numbers are consecutive or not ##

**Given a valid String of Numbers separated by comma, check whether the given number are consecutive or not**

**This exercise contains a class CheckingForConsecutiveNumbersApp with the following methods:**

    +readInput() : void
        -Should accept inputs from the console
        -Should call inputValidator method with given input
------------------------------------------------------
    +inputValidator(String) : void
        -Should accept input as String and validates the input 
        -Should print "Given numbers are Consecutive" if given numbers are Consecutive 
        -Should print "Given numbers are not Consecutive" if given numbers are not Consecutive 
        -Should call method checkForConsecutive method
------------------------------------------------------
    +checkForConsecutive(String) : boolean
        -Should get String as input and return result as boolean
        -Should check given numbers are consecutive or not
------------------------------------------------------
    +outputPrinter(Object) : void
        -Should accept any type as input and print it

## Example
    Sample Input:
    2,3,6,5,4,1
    
    Expected Output:   
    Given numbers are Consecutive
--------------------------------------------------------
    Sample Input:
    -2,-1,-4,-5,-3
    
    Expected Output:
    Given numbers are Consecutive    
--------------------------------------------------------
    Sample Input:
    2,4,5,7,9,8
    
    Expected Output:
    Given numbers are not Consecutive
## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding