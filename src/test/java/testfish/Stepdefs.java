package testfish;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Stepdefs {
    @Given("^browser \"([^\"]*)\"$")
    public void browser(String arg1) throws Throwable {
        System.out.println("Success");
    }

    @When("^User send request to \"([^\"]*)\"$")
    public void user_send_request_to(String arg1) throws Throwable {
        System.out.println("Success");

    }

    @Then("^User get message with response code (\\d+)$")
    public void user_get_message_with_response_code(int arg1) throws Throwable {
        System.out.println("Success");

    }

}
