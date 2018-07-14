package com.ivan.mutantapi;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class Resources {
    @GET
    @Path("/stats")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDNAVerificationStatistics() {
        return "Not implemented yet";
    }

    @POST
    @Path("/mutant")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isMutant(String requestBody) {
        return MutantCheckerService.verifyDNA(requestBody);
    }
}