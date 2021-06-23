import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTesting {

    @Test
    public void getMethod(){
        /*// send a get request and validate status code equals 200
        given().when().get("https://jsonplaceholder.typicode.com/users")
                .then().statusCode(200);*/

        /*// print statement to print all the logs
        given().when().get("https://jsonplaceholder.typicode.com/users").then().log().all();*/

        /*// print statement to print only the body(the users), without the header
        given().when().get("https://jsonplaceholder.typicode.com/users").then().log().body();*/

        /*// verify status code = 200
        int statusCode= given().when().get("https://jsonplaceholder.typicode.com/users").getStatusCode();
        Assertions.assertEquals(200, statusCode);*/

        /*// or we get verify the status code using rest assured assertion
        given().when().get("https://jsonplaceholder.typicode.com/users").then().assertThat().statusCode(200);*/

       /*//display one specific user
        given().queryParam("id", "5").when().get("https://jsonplaceholder.typicode.com/users").then().log().body();*/

       /* //validate a specific value in our response body
        given().queryParam("id", "5").when().get("https://jsonplaceholder.typicode.com/users")
                .then().log().body().extract().path("name").equals("Chelsey Dietrich");*/

        /*//print the address
        String address=given().queryParam("id", "5").when().get("https://jsonplaceholder.typicode.com/users")
                .then().extract().path("address").toString();
        System.out.println(address);*/

       /* //print the city in the address
        String address=given().queryParam("id", "5").when().get("https://jsonplaceholder.typicode.com/users")
                .then().extract().path("address.city").toString();
        System.out.println(address);*/

      // make an assertion on the street of an address
        given().queryParam("id","4").when().get("https://jsonplaceholder.typicode.com/users").then()
           .extract().path("address.street").equals("Hoeger Mall");

       /* //extract the geo attribute using a string
        String geo =given().queryParam("id","4").when().get("https://jsonplaceholder.typicode.com/users").then()
                .extract().path("address.geo").toString();
        System.out.println(geo);*/
    }
    @Test
    public void displayattribute(){
        // using the key name
        String zip =given().queryParam("name","Nicholas Runolfsdottir V").when().get("https://jsonplaceholder.typicode.com/users").then()
                .extract().path("address.zipcode").toString();
        System.out.println(zip);
    }
}
