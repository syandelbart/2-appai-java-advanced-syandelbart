package fact.it.primecalculator.models;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeCalculator {


    public boolean isPrime(Integer number) {
        if(number < 1) {
            return false;
        }

        //Given that after the square root of a number, the following numbers are essentially the first
        // numbers multiplied by a factor, we can conclude that these will not match if the first didn't match.
        for (int i = 2;i <= Math.sqrt(number);i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> getAllPrimesUntil(Integer number) {
        // We could improve this dramatically... one example would be to remove all numbers that are dividable by 2
        return this.getlistOfAllNumbersUntil(2,number)
                .stream()
                .filter(i -> isPrime(i))
                .toList();
    }

    public List<Integer> getlistOfAllNumbersUntil(Integer start, Integer end) {
        return IntStream.range(start,end).boxed().toList();
    }


}
