package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void generatePrimesBetween1And50() {
        PrimeGenerator primeGenerator = new PrimeGenerator(1, 50);
        primeGenerator.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L};
        assertArrayEquals(expectedPrimes, primeGenerator.getPrimes().toArray());

    }

    @Test
    public void inValidInputsBothFromAndToAreSame() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(10, 10);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 10 + " to=" + 10, ex.getMessage());
        }
    }

    @Test
    public void inValidInputsFromIsNegativeNumber() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(-20, 10);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + -20 + " to=" + 10, ex.getMessage());
        }
    }

    @Test
    public void inValidInputsToIsNegativeNumber() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(20, -10);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 20 + " to=" + -10, ex.getMessage());
        }
    }

    @Test
    public void inValidInputsFromIsGreaterThanTo() {
        try {
            PrimeGenerator primeGenerator = new PrimeGenerator(20, 10);
            primeGenerator.generatePrimes();
        } catch (Exception ex) {
            assertEquals("Wrong input values: from=" + 20 + " to=" + 10, ex.getMessage());
        }
    }

}
