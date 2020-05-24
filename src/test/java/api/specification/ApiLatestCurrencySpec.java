package api.specification;

import api.utils.DateUtil;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import api.utils.RequestDatas;

import static org.hamcrest.Matchers.lessThan;

public class ApiLatestCurrencySpec {

    public static RequestSpecification requestSpecification =
            new RequestSpecBuilder()
                    .setBaseUri(RequestDatas.BASE_URL)
                    .setContentType(ContentType.JSON)
                    .setBasePath("/api/latest")
                    .build();

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
