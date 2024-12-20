package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FancodeRoutes {

	private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

	// Get all users
	public static Response getAllUsers() {
		return RestAssured.given().baseUri(BASE_URL).get("/users");
	}

	// Get todos by userId
	public static Response getTodosByUserId(int userId) {
		return RestAssured.given().baseUri(BASE_URL).get("/todos?userId=" + userId);
	}

}
