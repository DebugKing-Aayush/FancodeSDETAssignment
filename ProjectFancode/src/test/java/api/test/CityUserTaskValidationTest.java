package api.test;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.FancodeRoutes;
import api.payloads.Todo;
import api.payloads.Users;
import io.restassured.response.Response;

public class CityUserTaskValidationTest {
	// Latitude and Longitude for FanCode city (as per the given range)
	private static final double MIN_LAT = -40;
	private static final double MAX_LAT = 5;
	private static final double MIN_LONG = 5;
	private static final double MAX_LONG = 100;

	// Test to validate that all users in the 'FanCode' city have more than 50%
	// completed tasks
	@Test(priority = 1)
	public void validateUsersWithMoreThan50PercentCompletedTasks() {
		// Fetch all users
		Response userResponse = FancodeRoutes.getAllUsers();
		// Log the API response (for debugging)
		System.out.println("User Response: " + userResponse.getBody().asString());

		List<Users> users = userResponse.jsonPath().getList("$", Users.class);

		// Verify if geo data is properly populated
		for (Users user : users) {
            if (user.getAddress() != null && user.getAddress().getGeo() != null) {
                System.out.println("Geo data for user: " + user.getName() + " | Lat: " + user.getAddress().getGeo().getLat() + " | Long: " + user.getAddress().getGeo().getLng());
            } else {
                System.out.println("Geo data missing for user: " + user.getName());
            }
        }
		// Filter users by 'FanCode' city based on latitude and longitude
		List<Users> fanCodeUsers = users.stream().filter(user -> {
			if (user.getAddress().getGeo() != null) {
				double lat = user.getAddress().getGeo().getLat();
				double lng = user.getAddress().getGeo().getLng();
				return lat >= MIN_LAT && lat <= MAX_LAT && lng >= MIN_LONG && lng <= MAX_LONG;
			}
			return false;
		}).collect(Collectors.toList());

		System.out.println("Filtered " + fanCodeUsers.size() + " users from FanCode city.");

		// Validate each user's completed task percentage
		for (Users user : fanCodeUsers) {
			Response todosResponse = FancodeRoutes.getTodosByUserId(user.getId());
			List<Todo> todos = todosResponse.jsonPath().getList("$", Todo.class);
			long totalTasks = todos.size();
			long completedTasks = todos.stream().filter(Todo::isCompleted).count();
			double completionPercentage = (completedTasks / (double) totalTasks) * 100;

			// Log the user and completion percentage
			System.out.println("User: " + user.getName() + ", Completed Tasks: " + completedTasks + "/" + totalTasks
					+ " (" + completionPercentage + "%)");

			Assert.assertTrue(completionPercentage > 50,
					"User " + user.getName() + " has less than 50% completed tasks.");
		}
	}

}
