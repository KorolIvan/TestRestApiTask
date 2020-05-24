package api.specification;

import api.utils.DateUtil;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ApiLatestCurrencySpec extends AbstractBaseApiSpecification {

    public static ResponseSpecification responseStatus =
            new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification getResponseWithExpectedTime(int seconds) {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan((DateUtil.secondsToMilliseconds(seconds))))
                .build();
    }

}
