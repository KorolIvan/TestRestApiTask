package api.specification;

import api.utils.RequestDatas;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

public class AbstractBaseApiSpecification {

    private static RequestSpecBuilder getBaseUrl() {
        return new RequestSpecBuilder()
                .setBaseUri(RequestDatas.BASE_URL)
                .setContentType(ContentType.JSON);
    }

    public static RequestSpecification getPathEndpoint(String path) {
        return getBaseUrl().setBasePath(path).build();
    }

}
