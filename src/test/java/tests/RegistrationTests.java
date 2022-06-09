package tests;
import com.codeborne.selenide.Selenide;
import data.TestData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.*;
import steps.StepToDeleteUser;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class RegistrationTests {

    TestData testData = new TestData();
    String name = testData.getUserName();
    String email = testData.getUserEmail();
    String password = testData.getUserPassword();
    LoginPage loginPage;
    MainPage mainPage;
    RegistrationPage registrationPage;
    String customPassword = testData.getUserPassword(5);
    StepToDeleteUser stepToDeleteUser = new StepToDeleteUser();

    @Before
    public void initializationTestData() {

        System.setProperty("selenide.browser", "edge");
        open(testData.getRegistrationPageURL());
        loginPage = Selenide.page(LoginPage.class);
        mainPage = Selenide.page(MainPage.class);
        registrationPage = Selenide.page(RegistrationPage.class);
        registrationPage.registration(name, email, password);
    }

    @After
    public void afterClass() {
        stepToDeleteUser.deleteUser(email, password);
        Selenide.closeWebDriver();
    }

    @DisplayName("Sign up using too short password")
    @Test
    public void inputIncorrectPasswordTest() {
        loginPage.registrationLinkClick();
        registrationPage.registration(name, email, customPassword);
        assertTrue(loginPage.incorrectPasswordAlert().isDisplayed());
    }

    @DisplayName("check if it's possible to sign up")
    @Test
    public void successfulRegistrationTest() {
        //since in @Before annotation a new user was created, it is only needed to use
        //already created credentials to authorize under the created user
        loginPage.login(email, password);
        mainPage.doOrderButtonWait();
        assertTrue(mainPage.isOrderButtonVisible());
    }
}
