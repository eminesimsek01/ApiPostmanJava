package deleteRequest;

import baseUrls.DummyRestApiBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyRestApiTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Delete02 extends DummyRestApiBaseURL {
     /*
    Given
            1)https://dummy.restapiexample.com/api/v1/delete/2

        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 200 olduğunu
		 And
		    Response body in

		    {
    "status": "success",
    "data": "719",
    "message": "Successfully! Record has been deleted"
}

     */

    @Test public void delete02(){
        specification.pathParams("path","delete","id","2");
        Response response=given().spec(specification).contentType(ContentType.JSON).
                when().
                delete("/{path}/{id}");
        System.out.println("RESPONSE:");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        //Set Expected Data
        DummyRestApiTestData dummyRestApiTestData = new DummyRestApiTestData();
        HashMap<String,String> expectedDataMap = dummyRestApiTestData.setExpectedDataForDelete("success","2","Successfully! Record has been deleted");

        //Step4: Assertion

        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedDataMap.get("status"),jsonPath.getString("status"));
        assertEquals(expectedDataMap.get("data"),jsonPath.getString("data"));
        assertEquals(expectedDataMap.get("message"),jsonPath.getString("message"));

    }
}
