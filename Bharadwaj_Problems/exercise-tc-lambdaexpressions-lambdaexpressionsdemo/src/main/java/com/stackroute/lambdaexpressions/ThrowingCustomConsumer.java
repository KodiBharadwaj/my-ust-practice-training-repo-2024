package com.stackroute.lambdaexpressions;


import java.util.function.Consumer;

/**
 * Custom Consumer functional interface to handle both checked and Unchecked Exceptions
 *  @param <T> the type of the input to the function
 *  @param <E> the type of the thrown checked exception
 */
@FunctionalInterface
public interface  ThrowingCustomConsumer<T, E extends Exception> {

    void accept(T inputParam) throws E;

    /*wrapper method takes two arguments, the lambda expression and the type of Exception to be caught.
     * @param throwingCustomConsumer
     * @param exceptionClass
     * This lambda wrapper is capable of handling all data types, not just Integers,
     * and catch any specific type of exception and throw any other checked exception
     * by wrapping them in an unchecked exception:.
     * @return Consumer<T> of generic type and throws checked exception wrapped in unchecked exception
     */

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
            ThrowingCustomConsumer<T, E> throwingCustomConsumer, Class<E> exceptionClass) {

        return param -> {
            try {
                throwingCustomConsumer.accept(param);
            } catch (Exception exception) {
                try {
                    E castException = exceptionClass.cast(exception);
                   throw new RuntimeException(castException);
                } catch (ClassCastException classCastException) {
                   throw new RuntimeException(exception);
                }
            }

        };
    }

}
