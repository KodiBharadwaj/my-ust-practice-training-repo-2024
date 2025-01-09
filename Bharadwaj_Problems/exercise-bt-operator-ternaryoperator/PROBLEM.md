## Problem Statement: Find whether given number is even/odd without using conditional statement. ##

**Given a number find whether it is Odd or Even using ternary operator and BigInteger**

**This exercise contains a class named NumberValidation with the following methods:**


    +numberValidator(BigInteger) : String
        -Should get BigInteger as input and return string "odd" or "even" 
        -Should check the number is odd or even
        -All Operations should be performed as BigInteger without type casting to primitive datatypes
------------------------------------------------------
    +inputValidator() : void
        -Should accept inputs from the console  
        -Should print error message "Give proper whole number which is not zero" if input is not integer and it is zero
        -Should print result as string like "The number is " followed by "odd" or "even"

## Example
    Sample Input:
    0
    
    Expected Output:   
    Give proper whole number which is not zero
--------------------------------------------------------
    Sample Input:
    1.2
    
    Expected Output:
    Give proper whole number which is not zero
--------------------------------------------------------
    Sample Input:
    153
    
    Expected Output:
    The number is odd
--------------------------------------------------------
    Sample Input:
    -942
    
    Expected Output:
    The number is even
--------------------------------------------------------
    Sample Input:
    22222222222
    
    Expected Output:
    The number is even
## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding