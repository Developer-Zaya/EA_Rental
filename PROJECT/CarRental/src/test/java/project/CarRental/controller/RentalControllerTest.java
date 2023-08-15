package project.CarRental.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RentalControllerTest {

    @Test
    public void testCreateRental() {
        given()
                .param("customerNumber", 12345)
                .param("startDate", "2023-05-01")
                .param("endDate", "2023-05-05")
                .param("carId", 67890)
                .when()
                .post("/rentals")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("customerNumber", equalTo(12345))
                .body("startDate", equalTo("2023-05-01"))
                .body("endDate", equalTo("2023-05-05"))
                .body("carId", equalTo(67890));
    }

    @Test
    public void testGetAllRentals() {
        given()
                .when()
                .get("/rentals")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", hasSize(greaterThan(0)));
    }

    @Test
    public void testPickupOrDrop() {
        given()
                .param("operation", "pickup")
                .param("street", "123 Main St")
                .param("city", "Anytown")
                .param("state", "CA")
                .param("zip", "12345")
                .when()
                .put("/rentals/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testCreatePayment() {
        given()
                .param("type", "credit")
                .param("amount", 100.0)
                .when()
                .post("/rentals/1/payments")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("type", equalTo("credit"))
                .body("amount", equalTo(100.0f));
    }
}
