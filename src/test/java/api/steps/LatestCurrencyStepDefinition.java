package api.steps;

import api.specification.ApiLatestCurrencySpec;
import cucumber.api.java.en.Then;

public class LatestCurrencyStepDefinition extends BasicStepsDefinition {

    @Then("^data collecting took less than (\\d+) seconds$")
    public void verifyThatDataCollectingTookLessThan(int seconds) {
        response.then()
                .spec(ApiLatestCurrencySpec.getResponseWithExpectedTime(seconds));
    }

}
