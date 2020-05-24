package api.specification;

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

public class BadRequestSpec extends AbstractBaseApiSpecification {

    public static ResponseSpecification responseStatus =
            new ResponseSpecBuilder()
                    .expectStatusCode(400)
                    .build();

}
