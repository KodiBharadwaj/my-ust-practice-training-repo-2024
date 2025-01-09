package com.stackroute.lambdaexpressions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LambdaExpressionsDemoTests {
    private LambdaExpressionsDemo lambdaExpressionsDemo;

    @BeforeEach
    public void setup(){
        lambdaExpressionsDemo = new LambdaExpressionsDemo();
    }
    @AfterEach
    public void teardown(){
        lambdaExpressionsDemo = null;
    }

    @Test
    public void ArithematicOperationMethodCalledWithlistContainsZeroValue(){
        assertThrows(RuntimeException.class,()->lambdaExpressionsDemo.arithmeticOperation(List.of(1,2,3,0,10), 10), "Use try catch to handle the exception");
    }

    @Test
    public void arithematicOperationMethodCalledWithEmptyList(){
        assertEquals(List.of(),lambdaExpressionsDemo.arithmeticOperation(List.of(),10));
    }

    @Test
    public void arithematicOperationMethodCalledWithNULLlist(){
        assertThrows(RuntimeException.class,()->lambdaExpressionsDemo.arithmeticOperation(null,10));
        assertThrows(RuntimeException.class,()->lambdaExpressionsDemo.arithmeticOperation(List.of(),null));
    }

    @Test
    public void writeToFileMethodCalledwithListofStringValuesand0Offset(){
        assertEquals(List.of("file1.txt","file2.txt","file3.txt"),lambdaExpressionsDemo.writeToFile(0,List.of("Kodi","Bharadwaj","Chekuri")));
    }
    @Test
    public void writeToFileMethodcalledWithListofStringValuesandOffset10(){
        assertThrows(RuntimeException.class,()->lambdaExpressionsDemo.writeToFile(10,List.of("Kodi","Bharadwaj","Chekuri")));

    }
    @Test
    public void writeToFileMethodCalledWithemptyListandanOffset(){
        assertEquals(List.of(),lambdaExpressionsDemo.writeToFile(0,List.of()));
    }
    @Test
    public void writeToFileMethodCalledWithnullValues(){
        assertThrows(RuntimeException.class,()->lambdaExpressionsDemo.writeToFile(0,null));

    }





}
