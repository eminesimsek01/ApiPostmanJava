package getRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class Get01 {
/*
    Given
        https://restful-booker.herokuapp.com/booking/781
    When
        Kullanıcı GET Methodu ile Request Gönderir
    Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
     */
    @Test // It is like the main method
     public void get01() {
        /*
        4 tane adımımız vardır.
        1)Url'i tanımlamam lazım
        2)Expected dataları tanımlamam, set etmem lazım. Expected datalar test caseden alınır.Doc'dan alınır.
        Şu an için bu step ignore edilecektir.
        3)Request Gönder

        4)Assertion İşlemi
         */
        //Step 1: Url'i set ediniz.
        String url=" https://restful-booker.herokuapp.com/booking/781";

        //Step2: Expected dataları set et. (Ignore edilmiştir)

        //Step3:Request Gönder
        Response response=given().
                when().
                get(url);
        System.out.println("RESPONSE");
        response.prettyPrint();//prettyPrint() syso gibidir.
        /*
        Then
        Status Code un "200" olduğunu Assert et
    And
        Content Type ın "application/json" olduğunu assert et
    And
        Status Line "HTTP/1.1 200 OK" olduğunu assert et.
         */
        //Test1: status code=--->200
        response.then().assertThat().statusCode(200);//Doc. test caseden alınmıştır

        //Test2: Content Type
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().contentType(ContentType.JSON);

        //Test3: Status Line
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        //Status Code'u consola nasıl yazdırabiliriz.
        System.out.println("Status Code: "+ response.getStatusCode());

        //Content Type'ı konsalo nasıl yazdırabiliriz.
        System.out.println("response.getContentType() = " + response.getContentType());

        //Status Line'ı nasıl yazdırabiliriz.
        System.out.println("response.getStatusLine() = " + response.getStatusLine());

        //Response Time'ı nasıl yazdırabiliriz.
        System.out.println("response.getTime() = " + response.getTime());

        //Headersları konsola nasıl yazdırabiliriz.,
        System.out.println("response.getHeaders() = " + response.getHeaders());
    }
}
