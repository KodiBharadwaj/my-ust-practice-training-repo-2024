## Problem Statement: Find whether given number is a Strong Number or not. Strong Numbers are the numbers whose sum of factorial of digits is equal to the original number. ##

**Given a number, check if it is a Strong Number or not using Conditional statements and loops**

**This exercise contains a class named StrongNumber with the following methods:**

    +inputAcceptor() : void
        -Should accept inputs from the console 
        -Should call inputValidator method with given input
------------------------------------------------------
    +checkStrongNumber(int) : boolean
        -Should get int as input and return boolean true or false 
        -Should check whether number is strong number or not
------------------------------------------------------
    +inputValidator(int) : void
        -Should accept input as int and validate it 
        -Should print error message "Give proper input not negative number" if input is negative number
        -Should print error message "Give proper input not zero" if input is zero
        -Should call method checkStrongNumber method with input
------------------------------------------------------
    +outputPrinter(Object printStatement) : void
        -Should accept any type as input and print it


## Example
    Sample Input:
    -120
    
    Expected Output:   
    Give proper input not negative number
--------------------------------------------------------
    Sample Input:
    145
    
    Expected Output:
    true    
--------------------------------------------------------
    Sample Input:
    0
    
    Expected Output:
    Give proper input not zero
--------------------------------------------------------
    Sample Input:
    122
    
    Expected Output:
    false
## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding