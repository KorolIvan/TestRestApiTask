package api.specification;

import api.utils.DateUtil;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ApiLatestCurrencySpec extends AbstractBaseApiSpecification {

//    private static final String LATEST_BASE_PATH = "/api/latest";
//    private static final String WRONG_PATH = "/api";

//    public static RequestSpecification requestSpecification =
//            new RequestSpecBuilder()
//                    .setBasePath("/api/latest")
//                    .build();

    public static ResponseSpecification responseStatus =
            new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();

    public static ResponseSpecification getResponseWithExpectedTime(int seconds) {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan((DateUtil.secondsToMilliseconds(seconds))))
                .build();
    }

//    @Override
//    public RequestSpecification getPathEndpoint() {
//        return getBaseUrl()
//                .setBasePath(LATEST_BASE_PATH)
//                .build();
//    }
}
