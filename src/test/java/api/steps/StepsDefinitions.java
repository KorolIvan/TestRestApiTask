package api.steps;


import api.model.BaseCurrency;
import api.specification.AbstractBaseApiSpecification;
import api.utils.DateUtil;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.jayway.restassured.RestAssured.*;

public class StepsDefinitions extends BasicStepsDefinition {

    private RequestSpecification request;


    @Given("^I perform to GET method for \"(.+)\" currency rates$")
    public void performGetLatestCurrencyRates(String endpoint) {
        request = given().spec(AbstractBaseApiSpecification.getPathEndpoint(endpoint));
    }


    @When("^I sending request to get currency rates$")
    public void sendRequestToGetCurrencyRate() {
        response = request.when().get();
    }

    @Then("^status is equals (\\d+)$")
    public void verifyThatStatusCodeEquals200OK(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
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
