package getRequest;

import baseUrls.GoRest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class Get06 extends GoRest {
    /*
        Given
            https://gorest.co.in/public/v2/todos/14091
        When
             Kullanıcı GET Methodu ile Request Gönderir
        Then
            Status Code un "200" olduğunu Assert et
		And
            Content Type ın "application/json" olduğunu assert et
        And
            Response Body nin aşağıdai gibi olduğunu asssert et
       {
    "id": 14071,
    "user_id": 592752,
    "title": "Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",
    "due_on": "2023-03-20T00:00:00.000+05:30",
    "status": "pending"
}
 */
    //Step1: Set Url
    @Test
    public void get06() {
        specifications.pathParams("todosPath", "todos", "todosid", "14071");

        //Step2:Set expected data Ignored

        // Step 3: Send a Request
        Response response = given().
                spec(specifications).
                when().
                get("/{todosPath}/{todosid}"); // get metodumun içierisne çalışacğaım endpoşntleri
        // sytanx ıne uygun bir şekilde yazmalıyım.
        response.prettyPrint(); // like sys

        //Step4: Assertion
        /*
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("id" , equalTo(14205) ,
                        "user_id" ,equalTo(629003) ,
                        "title" , containsString("cunabula") ,
                        "due_on" , equalTo("2023-03-07T00:00:00.000+05:30"),
                        "status" , equalTo("pending"));
         */
        //2. Way--> JsonPath
       // Json Path bir clastır ve Json objeler içerisinde navigate etmemize olanak sağlar.
       JsonPath jsonPath=response.jsonPath();
       assertEquals(592752,jsonPath.getInt("user_id"));
       assertEquals("Pariatur spoliatio odit defaeco uberrime ambulo asperiores velut et eveniet.",jsonPath.getString("due_on"));
        assertEquals("2023-03-20T00:00:00.000+05:30",jsonPath.getString("due_on"));
        assertEquals("pending",jsonPath.getString("status"));

       /*
       Expected Data: TEST CASE -- Doc. --- TEst Scen.
       Actual Data:::  RESPONSE
        */
    }
}
