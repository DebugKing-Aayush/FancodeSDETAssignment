package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FancodeRoutes {

//	public static String base_URL = "http://jsonplaceholder.typicode.com/";
//
//	// Authentication Module
//	public static String users_URL = base_URL + "/users";
//	public static String todos_URL = base_URL + "/todos";
//	public static String posts_URL = base_URL + "/posts";
//	public static String comments_URL = base_URL + "/comments";
//	public static String albums_URL = base_URL + "/albums";
//	public static String photos_URL = base_URL + "/photos";
//
//	private static final double MIN_LAT = -40;
//	private static final double MAX_LAT = 5;
//	private static final double MIN_LONG = 5;
//	private static final double MAX_LONG = 100;

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
