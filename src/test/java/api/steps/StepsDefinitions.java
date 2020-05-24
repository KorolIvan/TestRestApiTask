package api.steps;


import api.model.BaseCurrency;
import api.specification.ApiLatestCurrencySpec;
import api.utils.DateUtil;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.*;

public class StepsDefinitions extends BasicStepsDefinition {

    private Response response;
    private RequestSpecification request;


    @Given("^I perform to GET method for \"(.+)\" currency rates$")
    public void performGetLatestCurrencyRates(String endpoint) {
//        request = given().spec(ApiLatestCurrencySpec.requestSpecification);
        request = given().spec(getLatestCurrencySpec().getPathEndpoint(endpoint));
    }


    @When("^I sending request to get latest currency rates$")
    public void sendRequestToGetUpToDateCurrencyRate() {
        response = request.when().get();
    }

    @Then("^status is equals SUCCESS$")
    public void verifyThatStatusCodeEquals200OK() {
        response.then().spec(ApiLatestCurrencySpec.responseStatus);
    }

    @Then("^data collecting took less than (\\d+) seconds$")
    public void verifyThatDataCollectingTookLessThan(int seconds) {
        response.then()
                .spec(ApiLatestCurrencySpec.getResponseWithExpectedTime(seconds));
    }

    @Then("^the date is equals to today date$")
    public void verifyThatResponseDateIsEqualsToTodayDate() {
        BaseCurrency currency = response
                .then()
                .extract()
                .body()
                .as(BaseCurrency.class);
        Assert.assertEquals(DateUtil.getTodayDate(), currency.getDate());
    }

}
