package testfish;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.json.JSONException;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class Stepdefs {

    Response response;
    public int sentence = 3;
    public int paragraph = 3;
    public int title = 1;
    public int number = 0;
    public String typeOfParameter ="";


    public String getStatus(JsonPath jsonPath){
        return jsonPath.getString("status");

    }

    public int getSentence(JsonPath jsonPath){
        return 0;

    }


    @When("^User send request to \"([^\"]*)\"$")
    public void user_send_request_to(String arg1) throws JSONException {

        if (typeOfParameter.equals("")){
            response = get(arg1);
            Assert.assertEquals(getStatus(response.jsonPath()), "success");
        }
        else{
            response = get(String.format( "%s?type=%s&number=%d",arg1,typeOfParameter, sentence));
            Assert.assertEquals(getStatus(response.jsonPath()), "success");
        }


    }

    @Then("User get message with status {string}")
    public void user_get_message_with_status(String arg1) {
        Assert.assertEquals(getStatus(response.jsonPath()),arg1);

    }

    @Then("User get {int} {string}")
    public void user_get(Integer int1, String typeofrequest) {
        int count = 0;
        sentence = int1;
        String spl = "";
        if (typeofrequest.equals("sentences")){
            count = StringUtils.countMatches(response.jsonPath().getString("text"),".");
        }
        Assert.assertEquals(sentence, count);
    }

    @Given("type of parameter request {string}")
    public void type_of_parameter_request(String string) {
        typeOfParameter = string;

    }

    @Given("count {int}")
    public void count(Integer int1) {
        number = int1;

    }




}
