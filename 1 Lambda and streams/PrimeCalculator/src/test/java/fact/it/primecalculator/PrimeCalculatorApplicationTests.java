package fact.it.primecalculator;

import fact.it.primecalculator.models.PrimeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class PrimeCalculatorApplicationTests {
	@Test
	public void testNumberRange() {
		PrimeCalculator primeCalculator = new PrimeCalculator();
		List<Integer> outcome = primeCalculator.getlistOfAllNumbersUntil(0,26);

		int[] outcomeNumbers = outcome.stream().mapToInt(Integer::intValue).toArray();
		int[] expectedNumbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};

		assertArrayEquals(expectedNumbers,outcomeNumbers);


	}

	@Test
	public void testIsPrime() {
		PrimeCalculator primeCalculator = new PrimeCalculator();
		List<Integer> primeNumbers = List.of(2,3,5,7);
		List<Integer> nonPrimeNumbers = List.of(4,6,8,9,10);

		primeNumbers.stream().forEach((primeNumber) -> {
				assertTrue(primeCalculator.isPrime(primeNumber));
		});

		nonPrimeNumbers.stream().forEach((nonPrimeNumber) -> {
			assertFalse(primeCalculator.isPrime(nonPrimeNumber));
		});

	}

	@Test
	public void testAllPrimes() {
		PrimeCalculator primeCalculator = new PrimeCalculator();
		//From 0 to 30
		int[] primeNumbers = {2,3,5,7,11,13,17,19,23,29};
		int[] confirmedPrimeNumbers = primeCalculator.getAllPrimesUntil(30).stream().mapToInt(Integer::intValue).toArray();

		assertArrayEquals(primeNumbers,confirmedPrimeNumbers);

	}
}
