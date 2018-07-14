package com.ivan.mutantapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;

public class MutantCheckerService {
    private static JsonParser jsonParser = new JsonParser();


    public static Response verifyDNA(String requestBody) {
        MutantChecker mutantChecker = MutantChecker.getInstance();
        JsonObject jsonRequest = (JsonObject)jsonParser.parse(requestBody);
        JsonArray jsonArray = jsonRequest.getAsJsonArray("dna");
        if (jsonArray == null) {
            return Response.ok("No parameter dna was given")
                    .status(Status.BAD_REQUEST).build();
        }
        ArrayList<String> dna = new ArrayList<String>();
        for (int i = 0; i < jsonArray.size(); i++) {
            dna.add(jsonArray.get(i).toString());
        }

        if (mutantChecker.isMutant(dna.toArray(new String[dna.size()]))) {
            return Response.ok("").status(Status.OK).build();
        } else {
            return Response.ok("").status(Status.FORBIDDEN).build();
        }
    }
}
