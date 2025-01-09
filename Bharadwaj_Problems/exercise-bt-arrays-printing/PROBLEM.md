## Printing all the Sub Arrays of an Array   

### Problem Statement

Given a valid Input Array, you need to write a method that will generate all the sub arrays of the input array and computes the sum for each sub arrays. The 
method has to store all the sub arrays in a 2D array and sort the 2D array according to the sum of the sub arrays, where, sub array with the maximum sum will 
occupies the first position and the sub array with the least sum will occupies the last position of the 2D array.Then, the method has to return the sorted 2D array 
with the sub arrays of different sizes. 
### Input Format  

The Application takes two lines of input. The First line should have one value that will specify the size of the input Array. The size should be 
greater than 1, for the input Array to be considered as valid. The second line should have the array values, equal to the size, separated by space.
 
### Output Format  

The application should print the sorted 2D array, returned by the method, one sub array per line and the values in each line should be separated by space. If the method returns 'null', the application should 
print 'Insufficient Array Elements'.  

### Sample TestCases  

#### TestCase 1  
    
    Input    
    4      
    1 2 3 4  
     
    Output    
    1 2 3 4  
    2 3 4  
    3 4  
    1 2 3   
    2 3  
    4  
    1 2   
    3   
    2   
    1  
       
 
#### TestCase 2  

    Input  
    5
    3 6 -4 12 -9  
    
    Output  
    3 6 -4 12   
    6 -4 12   
    12   
    3 6   
    -4 12   
    3 6 -4 12 -9   
    6   
    3 6 -4   
    6 -4 12 -9   
    3   
    12 -9   
    6 -4   
    -4 12 -9   
    -4   
    -9  
    
       
#### TestCase 3  

    Input  
    1  
    23  
        
    Output  
    Insufficient Array Elements  
    


   

 
