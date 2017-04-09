package com.apex.shipstation;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class API {

	private String api_key;
	private String api_secret;

	public API(String key, String secret) {
		api_key = key;
		api_secret = secret;
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
				String auth = api_key + ":" + api_secret;
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
				String auth = api_key + ":" + api_secret;
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

	public List<Carrier> listCarriers(){
		

		
		Response res = GET("https://ssapi.shipstation.com/carriers");

		// api exception
		if (res == null) {
			LOGGER.log("ShipStation API Exception! ", Level.SEVERE);
			return -1;
		}

		// check status -
		// http://docs.shipstation.apiary.io/#introduction/shipstation-api-requirements/server-responses
		if (res.getStatus() != 200) {
			LOGGER.log("ShipStation API Response NOT OK : " + res.getStatus(), Level.SEVERE);
			return -1;
		}
		
		
		
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(res.readEntity(String.class, new TypeReference<List<Carrier>>(){});		
		
	}
}
