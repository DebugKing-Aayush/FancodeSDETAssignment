package api.utilities;

import io.restassured.response.Response;

public class Utils {
	// Log response status code
	public static void logResponseStatus(Response response) {
		System.out.println("Response Status Code: " + response.getStatusCode());
	}

}
