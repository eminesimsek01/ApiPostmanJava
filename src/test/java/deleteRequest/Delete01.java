package deleteRequest;

import baseUrls.RestFullBookerHerOkuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Delete01 extends RestFullBookerHerOkuAppBaseURL {
        /*
        Given
            1)https://restful-booker.herokuapp.com/booking/5
            2)Auth olarak HEader da Cookie ile token=001832eb39ba0ca gönderiniz
        When
	 	    Kullanıcı Delete ile request atar
	 	Then
		 	Status code un 201 olduğunu
		 And
		    Response body de "Created" yazdığını verify ediniz.
     */

    /*
    POST ile bookinge post ettiğiniz zaman delete edebiliriz.
    delete_bookingID: [1, 5, 7, 8]
     */
    @Test
    public void delete01(){
        //Step1:Set the URL
        //https://restful-booker.herokuapp.com/booking/5
        specification.pathParams("bookingPath","booking","bookingid","5");

        //Step2: Set the Expected Data
        //Ignore

        //Step 3: Send a Request
        Response response=given().spec(specification).contentType(ContentType.JSON).header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                when().
                delete("/{bookingPath}/{bookingid}");
        System.out.println("RESPONSE:");
        response.prettyPrint();

        //Step 4: Assertion
        response.then().assertThat().statusCode(201);
        String responseBody=response.asString();
        assertEquals(responseBody,"Created");


    }

}
