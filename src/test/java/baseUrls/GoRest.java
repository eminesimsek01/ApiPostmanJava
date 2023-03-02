package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRest {
    protected RequestSpecification specifications;
    //     https://gorest.co.in/public/v2/todos/725273---->> Base URL
    @Before
    public void setUpBaseURL(){
        specifications = new RequestSpecBuilder().
                setBaseUri("   https://gorest.co.in/public/v2/todos/725273").
                build();
    }
}
