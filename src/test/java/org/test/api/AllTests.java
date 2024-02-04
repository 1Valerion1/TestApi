package org.test.api;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.test.api.filesController.UnlDownTest;
import org.test.api.gameNew.GameTest;
import org.test.api.jwtToken.TokenTest;
import org.test.api.train.TrainTest;
import org.test.api.userNew.UserTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AllTests {

    @Test
    @Order(1)
    public void testTrain() {
        TrainTest trainTest = new TrainTest();
        trainTest.testEasyNumsOk();
        trainTest.testBadRequest();
        trainTest.testNotFound();
    }

    @Test
    @Order(2)
    public void testFile() {
        UnlDownTest unloadDownTest = new UnlDownTest();
        unloadDownTest.UnloadTestFile();
        unloadDownTest.DownloadTestFile();
    }

    @Test
    @Order(3)
    public void testUserGameJwt() {
        UserTest userTest = new UserTest();
        userTest.successRegTest();

        TokenTest tokenTest = new TokenTest();
        tokenTest.getTestAToken();

        GameTest gameTest = new GameTest();
        gameTest.getTestBAllGames();
        gameTest.getTestCAddGame();
        gameTest.getTestDAllGamesUp();
        gameTest.getTestEDeleteGame();



        userTest.getPutUser();
        userTest.getGetUser();
        userTest.getDeleteUser();
    }




}
