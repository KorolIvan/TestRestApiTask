package api.steps;


import api.specification.ApiLatestCurrencySpec;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.*;

public class StepsDefinitions {

    private Response response;
    private RequestSpecification request;


    @Given("^I perform to GET method for latest currency rates$")
    public void performGetLatestCurrencyRates() {
        request = given().spec(ApiLatestCurrencySpec.requestSpecification);
    }


    @When("^I sending request to get latest currency rates$")
    public void sendRequestToGetUpToDateCurrencyRate() {
        response = request.when().get();
    }

    @Then("^status is equals SUCCESS$")
    public void verifyThatStatusCodeEquals200OK() throws Exception {
        response.then().spec(ApiLatestCurrencySpec.responseStatus);
    }

    @Then("^data collecting took less than (\\d+) seconds$")
    public void verifyThatDataCollectingTookLessThan(int seconds) {
        response.then()
                .spec(ApiLatestCurrencySpec.getResponseWithExpectedTime(seconds));
    }

    @Then("^the date is equals to today date$")
    public void verifyThatResponceDateIsEqualsToTodayDate() {

    }

}
