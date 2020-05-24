package api.steps;


import api.model.BaseCurrency;
import api.specification.ApiLatestCurrencySpec;
import api.specification.BadRequestSpec;
import api.utils.DateUtil;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.*;

public class StepsDefinitions extends BasicStepsDefinition {

    private static Response response;
    private RequestSpecification request;


    @Given("^I perform to GET method for \"(.+)\" currency rates$")
    public void performGetLatestCurrencyRates(String endpoint) {
        request = given().spec(getLatestCurrencySpec().getPathEndpoint(endpoint));
    }


    @When("^I sending request to get currency rates$")
    public void sendRequestToGetCurrencyRate() {
        response = request.when().get();
    }

    @Then("^status is equals SUCCESS$")
    public void verifyThatStatusCodeEquals200OK() {
        response.then().spec(ApiLatestCurrencySpec.responseStatus);
    }


    @Then("^status is equals Bad Request$")
    public void verifyThatUserReceiveBadRequestStatus() {
        response.then().spec(BadRequestSpec.responseStatus);
    }

    @Then("^data collecting took less than (\\d+) seconds$")
    public void verifyThatDataCollectingTookLessThan(int seconds) {
        response.then()
                .spec(ApiLatestCurrencySpec.getResponseWithExpectedTime(seconds));
    }

    @Then("^the date is equals to today date$")
    public void verifyThatResponseDateIsEqualsToTodayDate() {
        Assert.assertEquals(DateUtil.getTodayDate(),
                getBaseCurrencyEntityFromResponse().getDate());
    }

    @Then("^the date is equals to \"([^\"]*)\" date$")
    public void theDateIsEqualsToDate(String expectedDate) {
        Assert.assertEquals(expectedDate,
                getBaseCurrencyEntityFromResponse().getDate());
    }

    private static BaseCurrency getBaseCurrencyEntityFromResponse() {
        return response
                .then()
                .extract()
                .body()
                .as(BaseCurrency.class);
    }
}
