package org.test.api.filesController;

import org.junit.jupiter.api.Test;
import org.test.api.Specifications;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UnlDownTest {

    @Test
    public void UnloadTestFile() {
        Specifications.installSpecification(Specifications.requestSpecMult(),Specifications.responseSpecOk200());

        File fileToUpload = new File("src/test/resources/downloadImage.jpg");

       given()
               .multiPart("file",fileToUpload)
               .when()
               .post("/api/files/upload")
               .then()
               .log().all()
               .extract()
               .response().asByteArray();


    }

    @Test
    public void DownloadTestFile() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOk200());

        String imagePath = "src/test/resources/downloadImage.jpg";

        byte[] imageBytes = given()
                .when()
                .get("/api/files/download")
                .then()
                .log().all()
                .extract()
                .response().asByteArray();


        try (FileOutputStream outputStream = new FileOutputStream(imagePath)) {

            outputStream.write(imageBytes);

            System.out.println("Изображение сохранено как:" + imagePath);

        } catch (IOException e) {

            System.err.println("Ошибка: " + e.getMessage());

        }
    }
}
