package testfish;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import java.io.IOException;

import static io.restassured.RestAssured.get;

public class Stepdefs {
    @Given("^browser \"([^\"]*)\"$")
    public void browser(String arg1) {
        System.out.println("Success");
    }

    @When("^User send request to \"([^\"]*)\"$")
    public void user_send_request_to(String arg1) throws JSONException {

        Response response = get(arg1);
        System.out.println(response);
        JSONArray jsonResponse = new JSONArray(response);
        String status = jsonResponse.getJSONObject(0).getString("status");
        Assert.assertEquals(status, "success");

    }

    @Then("^User get message with response code (\\d+)$")
    public void user_get_message_with_response_code(int arg1) {
        System.out.println("Success");

    }

}
