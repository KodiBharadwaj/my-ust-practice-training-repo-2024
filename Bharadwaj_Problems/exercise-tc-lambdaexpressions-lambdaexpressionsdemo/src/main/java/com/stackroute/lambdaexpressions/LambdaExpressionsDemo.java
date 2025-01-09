package com.stackroute.lambdaexpressions;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 * The class LambdaExpressionsDemo has two methods that demonstrates
 * the power of functional interfaces and lambda expressions
 * in handling exceptions keeping the code concise.
 */
public class LambdaExpressionsDemo {


    /**
     * Returns the list corresponding to division.     *
     * @param integers list of divisors for the element whose value needs to be returned
     * @param dividend
     * @return list of integer quotients after division
     * The lambda expression uses the functional interface to throw exceptions
     */
    public List<Integer> arithmeticOperation(List<Integer> integers, Integer dividend) {

        List<Integer> resultList = new ArrayList<>();
        if (integers != null && dividend != null) {
            integers.forEach(ThrowingCustomConsumer.handlingConsumerWrapper(divisor -> resultList.add(dividend / divisor), ArithmeticException.class));
        } else {
            throw new NullPointerException();
        }
        return resultList;
    }

    /**
     * Returns the list corresponding to division.     *
     * @param offset for file operations
     * @param namesList list of Strings to be written to a file
     * @return list of file names created after file operations
     * The lambda expression uses the functional interface wrapper  method
     * to handle only the IOException and throw any other
     * checked exception by wrapping them in an unchecked exception:
     */
    public List<String> writeToFile(int offset, List<String> namesList) {

        List<String> resultList = new ArrayList<>();
        if (namesList != null) {
            List<Integer> indexList = new ArrayList<>();
            indexList.add(1);
            namesList.forEach(ThrowingCustomConsumer.handlingConsumerWrapper(element -> {
                String fileName = "file" + indexList.get(0) + ".txt";
                FileOutputStream file = new FileOutputStream(fileName);
                byte[] bytes = element.getBytes();
                int length = bytes.length;
                file.write(bytes, offset, length);
                resultList.add(fileName);
                indexList.add(0, indexList.get(0) + 1);
            }, IOException.class));
            return resultList;
        } else {
            throw new NullPointerException();
        }
    }

}