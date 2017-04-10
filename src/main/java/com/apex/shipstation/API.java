package com.apex.shipstation;

import com.apex.shipstation.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.List;


public class API {


    private String apiBaseURL;
    private String apiKey;
    private String apiSecret;


    public API(String BaseURL, String key, String secret) {
        apiBaseURL = BaseURL;
        apiKey = key;
        apiSecret = secret;
    }

    private boolean checkRateLimit(Response response) throws InterruptedException {

        if (response.getStatus() == 429) {

            // http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/api-rate-limits
            long sec = 40;// default reset time 40 seconds

            // parse header that defines how long to wait
            if (response.getHeaders().containsKey("X-Rate-Limit-Reset")) {
                sec = Long.parseLong((String) response.getHeaders().get("X-Rate-Limit-Reset").get(0));
            }
            System.out.println("ShipStation API got (429)- Sleeping for " + (sec + 1) + " seconds");

            Thread.sleep((sec + 1) * 1000); // sleep

            return true; // wait occurred - retry request!
        }
        return false; // no wait - continue!
    }

    private int POST(String api_url, Entity payload) {

        // init
        boolean retry = true;
        Response response = null;

        do {
            try {

                // auth
                String auth = apiKey + ":" + apiSecret;
                String authB64 = Base64.getEncoder().encodeToString(auth.getBytes());

                // HTTP request
                Client client = ClientBuilder.newClient();
                response = client.target(api_url).request(MediaType.APPLICATION_JSON_TYPE)
                        .header("Authorization", "Basic " + authB64).post(payload);

                // check if we need to wait
                if (response != null) {
                    retry = checkRateLimit(response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (retry);// retry if we hit a rate limit

        return (response != null) ? response.getStatus() : -1; // return status
    }

    private Response GET(String api_url) {

        // init
        boolean retry = true;
        Response response = null;

        do {
            try {

                // auth
                String auth = apiKey + ":" + apiSecret;
                String authB64 = Base64.getEncoder().encodeToString(auth.getBytes());

                // HTTP request
                Client client = ClientBuilder.newClient();
                response = client.target(api_url).request(MediaType.TEXT_PLAIN_TYPE)
                        .header("Authorization", "Basic " + authB64).get();

                // check if we need to wait
                if (response != null) {
                    retry = checkRateLimit(response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (retry);// retry if we hit a rate limit

        return response;
    }

    public List<Tag> listTags() throws IOException {


        Response res = GET(apiBaseURL + "/accounts/listtags");

        // api exception
        if (res == null) {

            //	return NULL;
        }

        // check status -
        // http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/server-responses
        if (res.getStatus() != 200) {

            //	return NULL;
        }


        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Tag>>() {
        });

    }

    public List<Carrier> listCarriers() throws IOException {


        Response res = GET(apiBaseURL + "/carriers");

        // api exception
        if (res == null) {

            //	return NULL;
        }

        // check status -
        // http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/server-responses
        if (res.getStatus() != 200) {

            //	return NULL;
        }


        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(res.readEntity(String.class), new TypeReference<List<Carrier>>() {
        });

    }

    public Carrier getCarrier(String carrierCode) throws IOException {


        Response res = GET(apiBaseURL + "/carriers/getcarrier?carrierCode=" + carrierCode);

        // api exception
        if (res == null) {

            //	return NULL;
        }

        // check status -
        // http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/server-responses
        if (res.getStatus() != 200) {

            //	return NULL;
        }


        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(res.readEntity(String.class), Carrier.class);

    }

    public void addFunds(Fund fund){

        try{
        ObjectMapper mapper = new ObjectMapper();
        String fundJSON = mapper.writeValueAsString(fund);

        Entity<String> payload = Entity.text(fundJSON);


        int status = POST(apiBaseURL + "/carriers/addfunds", payload);

    } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }



    }
}
