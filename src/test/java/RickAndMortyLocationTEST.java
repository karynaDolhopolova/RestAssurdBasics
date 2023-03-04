import config.MySpecificationForRestAssured;
import data.location.Result;
import data.location.Root;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class RickAndMortyLocationTEST {

    @Test
    public void test() {
        Root root = when().get("https://rickandmortyapi.com/api/location").then().extract().as(Root.class);
        do {
            for (Result r : root.results) {
                System.out.println(r.dimension);
            }
            if (root.info.next != null) {
                root = when().get(root.info.next).then().extract().as(Root.class);
            } else {
                break;
            }
        } while (true);
    }
}