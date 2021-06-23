import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class HomeworkGet {

    @Test
    public void CheckCityID4() {

        //1- Verify user with id=4 lives in South Elvis city.
         given().queryParam("id", "4").when().get("https://jsonplaceholder.typicode.com/users")
                .then().extract().path("address.city").equals("South Elvis");
    }

    @Test
    public void CheckUserInfo() {
        //2-Verify name, email and username for each user.
           //2-1 Verify names
        String[] names = {"Leanne Graham", "Ervin Howell", "Clementine Bauch", "Patricia Lebsack", "Chelsey Dietrich", "Mrs. Dennis Schulist",
                "Kurtis Weissnat", "Nicholas Runolfsdottir V", "Glenna Reichert", "Clementina DuBuque"};
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < names.length; j++) {
                given().queryParam("id", i).when().get("https://jsonplaceholder.typicode.com/users").
                        then().extract().path("name").equals(names[j]);
            }
        }

           //2-2 Verify usernames
        String[] usernames= {"Bret","Antonette","Samantha","Karianne","Kamren", "Leopoldo_Corkery","Elwyn.Skiles","Maxime_Nienow","Delphine",
                "Moriah.Stanton"};
        for (int e = 1; e <= 10; e++) {
            for (int f = 0; f < usernames.length; f++) {
                given().queryParam("id", e).when().get("https://jsonplaceholder.typicode.com/users").
                        then().extract().path("username").equals(usernames[f]);
            }
        }

           //2-3 Verify emails
        String[] emails= {"Sincere@april.biz","Shanna@melissa.tv","Nathan@yesenia.net","Julianne.OConner@kory.org","Lucio_Hettinger@annie.ca",
        "Karley_Dach@jasper.info","Telly.Hoeger@billy.biz","Sherwood@rosamond.me","Chaim_McDermott@dana.io","Rey.Padberg@karina.biz"};
        for (int h = 1; h <= 10; h++) {
            for (int k = 0; k < emails.length; k++) {
                given().queryParam("id", h).when().get("https://jsonplaceholder.typicode.com/users").
                        then().extract().path("username").equals(emails[k]);
            }
        }
    }

    @Test
    public void CheckCompany(){
      //3- Verify company name for Leanne Graham
      String company="[{name=Romaguera-Crona, catchPhrase=Multi-layered client-server neural-net, bs=harness real-time e-markets}]";
      String companyactual = given().queryParam("name","Leanne Graham").when().get("https://jsonplaceholder.typicode.com/users").
                       then().extract().path("company").toString();
        Assertions.assertEquals(company, companyactual);
    }

    @Test
    public void CheckCatch(){
      //4-Verify catch phrase for Deckow-Crist company

        String cphrase="[Proactive didactic contingency]";
        String cphraseactual= given().queryParam("id",2).when().get("https://jsonplaceholder.typicode.com/users").
                then().extract().path("company.catchPhrase").toString();
        Assertions.assertEquals(cphrase,cphraseactual);
    }
    @Test
    public void CheckWebsite(){
       //5-Verify website for user with id=3
        String website="[ramiro.info]";
        String websiteactual= given().queryParam("id",3).when().get("https://jsonplaceholder.typicode.com/users").
                then().extract().path("website").toString();
        Assertions.assertEquals(website,websiteactual);
    }
    @Test
    public void CheckZipLanLat(){
        //6-Verify zipcode, lng and lat for Ervin Howell
        //6-1 zipcode
        String zip= given().queryParam("name", "Ervin Howell").when().get("https://jsonplaceholder.typicode.com/users").
                then().extract().path("address.zipcode").toString();
        Assertions.assertEquals("[90566-7771]",zip);

        //6-2 lng lat
        String lnglat="[{lat=-43.9509, lng=-34.4618}]";
        String ll= given().queryParam("name", "Ervin Howell").when().get("https://jsonplaceholder.typicode.com/users").
                then().extract().path("address.geo").toString();
        Assertions.assertEquals(lnglat, ll);

    }
}