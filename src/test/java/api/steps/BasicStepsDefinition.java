package api.steps;

import api.specification.ApiLatestCurrencySpec;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;


public class BasicStepsDefinition {

    private ApiLatestCurrencySpec latestCurrencySpec;

    public ApiLatestCurrencySpec getLatestCurrencySpec() {
        return latestCurrencySpec = new ApiLatestCurrencySpec();
    }

}
