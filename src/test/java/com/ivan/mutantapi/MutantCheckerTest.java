package com.ivan.mutantapi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MutantCheckerTest {
    private MutantChecker mutantChecker;

    @Test
    public void shouldReturnTrueForRowMatch() {
        String[] dna = {"AAAA",
                "ACGT",
                "CCCG",
                "TTAT"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueForColumnMatch() {
        String[] dna = {"AACAT",
                "ACGTT",
                "CCCGT",
                "TCATT",
                "CGGAA"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueForMainDiagonalMatch() {
        String[] dna = {"GAAA",
                "AGGT",
                "CCGG",
                "TTAG"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueForSecondaryDiagonalMatch() {
        String[] dna = {"GAAT",
                "AGTT",
                "CTCG",
                "TTAG"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueForMoreThanNeededMatches() {
        String[] dna = {"AAAAAA",
                "AAAAAA",
                "AAAAAA",
                "AAAAAA",
                "AAAAAA",
                "AAAAAA"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseForEmptyDna() {
        String[] dna = {};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseForNonMutantDna() {
        String[] dna = {"ACG",
                "CTT",
                "AAA"};
        boolean result = mutantChecker.isMutant(dna);
        Assert.assertFalse(result);
    }

    @Before
    public void setUp() {
        mutantChecker = new MutantChecker();
    }
}
