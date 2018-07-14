package com.ivan.mutantapi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MutantCheckerServiceTest {
    private MutantChecker mutantChecker;
    private MutantCheckerService mutantCheckerService;

    @Test
    public void shouldReturnHTTPStatus400() {
        String requestBody = "{\"peptide\":[\"CGGG\"," +
                "\"CGGG\"," +
                "\"CTTG\"," +
                "\"CTTA\"]}";
        Response response = mutantCheckerService.verifyDNA(requestBody);
        Assert.assertEquals(response.getStatus(), 400);
    }

    @Test
    public void shouldReturnHTTPStatus200() {
        String requestBody = "{\"dna\":[\"CGGG\"," +
                "\"CGGG\"," +
                "\"CTTG\"," +
                "\"CTTA\"]}";
        String dna[] = {"CGGG",
                        "CGGG",
                        "CTTG",
                        "CTTA"};
        when(mutantChecker.isMutant(dna)).thenReturn(true);
        Response response = mutantCheckerService.verifyDNA(requestBody);
        Assert.assertEquals(response.getStatus(), 200);
    }

    @Test
    public void shouldReturnHTTPStatus403() {
        String requestBody = "{\"dna\":[\"A\"]}";
        String[] dna = {"A"};
        when(mutantChecker.isMutant(dna)).thenReturn(false);
        Response response = mutantCheckerService.verifyDNA(requestBody);
        Assert.assertEquals(response.getStatus(), 403);
    }

    @Before
    public void setUp() {
        mutantChecker = mock(MutantChecker.class);
        mutantCheckerService = new MutantCheckerService();
    }
}
